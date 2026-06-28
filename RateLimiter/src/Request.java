import java.util.UUID;

public class Request {
    private final UUID clientId;
    private final String text;
    private final Long timestamp;

    public Request(UUID clientId, String text, Long timestamp) {
        this.clientId = clientId;
        this.text = text;
        this.timestamp = timestamp;
    }

    public UUID getClientId() {
        return clientId;
    }

    public String getText() {
        return text;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
