import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Bucket {
    Integer capacity;
    AtomicInteger tokens;
    Long lastFilledTimeStamp;
    int refillRate;

    public Bucket(Integer capacity, AtomicInteger tokens, Long lastFilledTimeStamp, int refillRate) {
        this.capacity = capacity;
        this.tokens = tokens;
        this.lastFilledTimeStamp = lastFilledTimeStamp;
        this.refillRate = refillRate;
    }

    public AtomicInteger getTokens() {
        return tokens;
    }

    public Long getLastFilledTimeStamp() {
        return lastFilledTimeStamp;
    }

    public void setTokens(AtomicInteger tokens) {
        this.tokens = tokens;
    }

    public void setLastFilledTimeStamp(Long lastFilledTimeStamp) {
        this.lastFilledTimeStamp = lastFilledTimeStamp;
    }

    public void refill() {
        long elapsedTime = System.currentTimeMillis() - lastFilledTimeStamp;
        int tokensToRefill = (int)(elapsedTime * refillRate/1000);
        int currToken = Math.min(capacity, tokensToRefill + tokens.get());
        if (tokensToRefill > 0) {
            tokens.set(currToken);
            setLastFilledTimeStamp(System.currentTimeMillis());
        }
    }
}
