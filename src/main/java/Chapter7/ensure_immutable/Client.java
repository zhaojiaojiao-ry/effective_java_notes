package Chapter7.ensure_immutable;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        Map<Key, Value> map = new HashMap<>();
        map.put(new Key(1, "xx"), new Value(124));
        map.put(new Key(2, "yy"), new Value(134));

        Container container = new Container(map);

        Map<Key, Value> map2 = container.getMap();// 得到一个全新的map，非container的内部结构
        map2.put(new Key(3, "zz"), new Value(333));
        System.out.println(container);// container内容不受put影响
        System.out.println(map2);

        Map<Key, Value> map3 = container.getMapView();// 得到一个container内部map的view，不能执行put，会抛异常
        try {
            map3.put(new Key(3, "zz"), new Value(333));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(container);
        System.out.println(map3);
    }
}
