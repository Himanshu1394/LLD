public class RateLimiter {
    private static RateLimiter instance;
    private RateLimitingStrategy rateLimitingStrategy;

    private RateLimiter() {
    }

    public static RateLimiter getInstance() {
        if (instance == null) {
            synchronized (RateLimiter.class) {
                if (instance == null) {
                    instance = new RateLimiter();
                }
            }
        }

        return instance;
    }

    public void setRateLimitingStrategy(RateLimitingStrategy rateLimitingStrategy) {
        this.rateLimitingStrategy = rateLimitingStrategy;
    }

    public Response processRequest(Request request) {
        return rateLimitingStrategy.allowRequest(request.getClientId(), request.getTimestamp());
    }
}
