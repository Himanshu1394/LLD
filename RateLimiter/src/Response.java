public enum Response {
    OK(200),
    TOO_MANY_REQUESTS(429);

    private int value;

    Response(int value) {
    }
}
