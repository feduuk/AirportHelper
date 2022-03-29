package column;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class ColumnImpl implements Column{
    private Integer columnNumber;
    @Override
    public int getNumber(String[] mainArgs) {
        if(mainArgs == null || mainArgs.length == 0){
            String fileName = "application.yaml";
            Yaml yaml = new Yaml();
            Map<String, Object> obj = null;
            try {
                InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
                obj = yaml.load(inputStream);
            } catch (Exception e) {
                System.out.println(fileName + " isn't present!");;
            }
            if(obj != null && obj.containsKey("columnNumber") ){
                try {
                    columnNumber = (int)obj.get("columnNumber");
                } catch (Exception e) {
                    System.out.println("columnNumber in application.yaml isn't an integer!");
                }
            }
        }else{
            try {
                columnNumber = Integer.parseInt(mainArgs[0]);
            } catch (NumberFormatException e) {
                System.out.println("columnNumber in args isn't an integer!");
            }
        }
        if(columnNumber != null && columnNumber < 1){
            System.out.println("columnNumber is too small!");
        }
        if(columnNumber == null || columnNumber < 1){
            columnNumber = 0;
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Please enter column number: ");
                try {
                    columnNumber = scanner.nextInt();
                    if(columnNumber < 1){
                        System.out.println("columnNumber is too small!");
                    }else{
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Input has to be an integer!");
                    scanner.nextLine();
                }
            }
        }
        return columnNumber;
    }
}
