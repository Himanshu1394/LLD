import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowStrategy implements RateLimitingStrategy{
    FixedWindowConfig config;
    Map<UUID, Map<Long, AtomicInteger>> requestCountMap;

    public FixedWindowStrategy(FixedWindowConfig config) {
        this.config = config;
        this.requestCountMap = new ConcurrentHashMap<>();
    }

    @Override
    public Response allowRequest(UUID clientId, long currTime) {
        long window = currTime/ config.getWindowSize();
        if (requestCountMap.containsKey(clientId)) {

            if (requestCountMap.get(clientId).containsKey(window)) {
                AtomicInteger currentRequestCount = requestCountMap.get(clientId).get(window);
                if (currentRequestCount.get() < config.getWindowLimit()) {
                    currentRequestCount.incrementAndGet();
                    requestCountMap.get(clientId).put(window, currentRequestCount);
                    return Response.OK;
                }
                return Response.TOO_MANY_REQUESTS;
            }

            else {
                requestCountMap.get(clientId).put(window, new AtomicInteger(1));
                return Response.OK;
            }
        }

        else {
            requestCountMap.put(clientId, new ConcurrentHashMap<>());
            requestCountMap.get(clientId).put(window, new AtomicInteger(1));
            return Response.OK;
        }
    }
}


