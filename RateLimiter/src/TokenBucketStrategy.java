import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenBucketStrategy implements RateLimitingStrategy {
    Map<UUID, Bucket> bucketMap;
    TokenBucketConfig config;

    public TokenBucketStrategy(TokenBucketConfig config) {
        this.config = config;
        this.bucketMap = new ConcurrentHashMap<>();
    }

    @Override
    public Response allowRequest(UUID clientId, long currTime) {
        Bucket bucket = bucketMap.computeIfAbsent(clientId, k -> new Bucket(config.getBucketCapacity(), new AtomicInteger(config.getBucketCapacity()), System.currentTimeMillis(), config.getRefillRate()));
        synchronized (bucket) {
            bucket.refill();
            int tokensLeft = bucket.getTokens().get();
            if (tokensLeft == 0) {
                return Response.TOO_MANY_REQUESTS;
            }
            bucket.getTokens().set(tokensLeft - 1);
            return Response.OK;
        }
    }
}
