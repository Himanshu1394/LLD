public class TokenBucketConfig {
    int bucketCapacity;
    int refillRate;

    public TokenBucketConfig(int bucketCapacity, int refillRate) {
        this.bucketCapacity = bucketCapacity;
        this.refillRate = refillRate;
    }

    public int getBucketCapacity() {
        return bucketCapacity;
    }

    public int getRefillRate() {
        return refillRate;
    }

    public void setBucketCapacity(int bucketCapacity) {
        this.bucketCapacity = bucketCapacity;
    }

    public void setRefillRate(int refillRate) {
        this.refillRate = refillRate;
    }
}
