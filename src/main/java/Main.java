import column.Column;
import column.ColumnImpl;
import column.ColumnService;

public class Main {

    public static void main(String[] args){
        ColumnService column = new ColumnService();
        int columnNumber = column.getNumber(args);
        System.out.println(columnNumber);
    }


}
