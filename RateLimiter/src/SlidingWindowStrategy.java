import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowStrategy implements RateLimitingStrategy {
    SlidingWindowConfig config;
    Map<UUID, Deque<Long>> slidingWindowMap;

    public SlidingWindowStrategy(SlidingWindowConfig config) {
        this.config = config;
        this.slidingWindowMap =  new ConcurrentHashMap<>();
    }

    @Override
    public Response allowRequest(UUID clientId, long currTime) {
        if (slidingWindowMap.containsKey(clientId)) {
            long windowStartTime = currTime - config.windowSize;
            Deque<Long> window = slidingWindowMap.get(clientId);
            while (!window.isEmpty() && window.peekFirst() < windowStartTime) {
                window.removeFirst();
            }

            int size = window.size();
            if (size < config.getWindowLimit()) {
                window.addLast(currTime);
                return Response.OK;
            }
            return Response.TOO_MANY_REQUESTS;
        }

        else {
            slidingWindowMap.put(clientId, new ArrayDeque<>());
            slidingWindowMap.get(clientId).addLast(currTime);
            return Response.OK;
        }
    }
}
