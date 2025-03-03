import java.security.PublicKey;
import java.util.Map;

public class Row {
    Integer row_id;
    Map<Column, Object> columData;

    public Row(Integer rowId, Map<Column, Object> columData){

        this.row_id = rowId;
        this.columData = columData;
    }


    public Integer getRow_id() {
        return row_id;
    }

    public Map<Column, Object> getColumData() {
        return columData;
    }
}
