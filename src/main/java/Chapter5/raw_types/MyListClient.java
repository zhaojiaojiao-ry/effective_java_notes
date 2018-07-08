package Chapter5.raw_types;

import java.util.ArrayList;
import java.util.List;

public class MyListClient {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        List<?> list = intList;
        for (Object data : list) {
            System.out.println(data);
        }
    }
}
