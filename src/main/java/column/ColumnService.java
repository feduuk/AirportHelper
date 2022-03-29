package column;

public class ColumnService {
    Column column;
    public ColumnService(){
        column = new ColumnImpl();
    }
    public int getNumber(String[] mainArgs){
        return column.getNumber(mainArgs);
    }
}
