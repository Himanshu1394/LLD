public class Column {

    String columnName;
    ColumnType type;

    public Column(String name, ColumnType type){

        this.columnName = name;
        this.type = type;
    }

    public String getColumnName() {
        return columnName;
    }
}
