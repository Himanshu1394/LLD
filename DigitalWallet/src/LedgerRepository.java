import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LedgerRepository {
    private final Map<UUID, List<LedgerEntry>> ledgerMap = new ConcurrentHashMap<>();

    public void saveLedger(UUID walletId, LedgerEntry ledgerEntry) {
        ledgerMap.computeIfAbsent(walletId, k -> new ArrayList<>()).add(ledgerEntry);
    }

    public Optional<List<LedgerEntry>> getLedger(UUID walletId) {
        return Optional.of(ledgerMap.getOrDefault(walletId, null));
    }
}
