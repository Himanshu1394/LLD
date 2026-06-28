import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiter.getInstance();
        RateLimitingStrategy rateLimitingStrategy = new TokenBucketStrategy(new TokenBucketConfig(10, 2));
        UUID requestId = UUID.randomUUID();
        rateLimiter.setRateLimitingStrategy(rateLimitingStrategy);
        long currTime = System.currentTimeMillis();
        for (int i=0; i<15; i++) {
            System.out.println(rateLimiter.processRequest(new Request(requestId, "Hello", currTime)));
        }
        Thread.sleep(5000);

        for (int i=0; i<11; i++) {
            System.out.println(rateLimiter.processRequest(new Request(requestId, "Hello", System.currentTimeMillis())));
        }
    }
}