import java.util.UUID;

public interface RateLimitingStrategy {
    public Response allowRequest(UUID clientId, long currTime);
}
