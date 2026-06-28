public class FixedWindowConfig {
    long windowSize = 10000;
    int windowLimit = 5;

    public FixedWindowConfig(long windowSize, int windowLimit) {
        this.windowSize = windowSize;
        this.windowLimit = windowLimit;
    }

    public long getWindowSize() {
        return windowSize;
    }

    public int getWindowLimit() {
        return windowLimit;
    }

    public void setWindowSize(long windowSize) {
        this.windowSize = windowSize;
    }

    public void setWindowLimit(int windowLimit) {
        this.windowLimit = windowLimit;
    }
}
