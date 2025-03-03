import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private String databaseName;
    private Map<String, Table> tableMap = new HashMap<>();

    public Database(String name){
        this.databaseName = name;
    }

    public void createTable(String tableName, List<Column> columns){

        if(checkExist(tableName)){

            return;
        }

        Table table = new Table(tableName, columns);
        tableMap.put(tableName, table);
        return;

    }

    public void dropTable(String name){
        tableMap.remove(name);
    }
}
