import java.util.*;

public class Table {
    Integer autoIncrementId;
    String tableName;
    Map<String, Column> columnMap = new HashMap<>();
    List<Row> rows = new ArrayList<>();

    public Table(String name, List<Column> columns){
        this.autoIncrementId = 1;
        this.tableName = name;
        populateColumnMap(colums);
    }

    public void truncateRows(){

        this.rows.clear();
    }

    public void insertRow(Map<Column, Object> columnValue){

        for(Column column: columnValue.keySet()){

            if(!checkIfColumnExists(column.getColumnName())){
                return;
            }
        }

        Map<Column, Object> columnData = new HashMap<>(columnValue);

        Integer rowId = getAutoIcrementId();
        Row row = new Row(rowId, columnData);
        this.rows.add(row);
    }

    public void printRows(){


    }

    public void getRecordsByColumnValues(Column c, Object value){

        List<Row> filteredRow = new ArrayList<>();

        for(Row row: this.rows){

            Object columnValue = row.getColumData().get(c);

            if(columnValue.equals(value)){
                filteredRow.add(row);
            }
        }

        printRecords(filteredRow);
    }

    public void printRecords(List<Row> rows){

        for(Map.Entry<String, Column> entry : this.columnMap.entrySet()){

            System.out.println(entry.getKey());

            for(Row row : rows){

                System.out.println(row.getRow_id());

                for(Map.Entry<Column, Object> entries : row.getColumData().entrySet()){

                    System.out.println(entries.getValue());
                }
            }
        }

    }

    public void populateColumnMap(List<Column> columns){

        for(Column column : columns){

            columnMap.put(column.getColumnName(), column);


        }
    }

    private synchronized Integer autoIncrementId(){
        return ++this.autoIncrementId;
    }

    private boolean checkIfColumnExists(String name){

        if(!columnMap.containsKey(name)){
            return false;
        }

        return true;
    }
}
