package Chapter7.ensure_immutable;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Container {
    private Map<Key, Value> map = new HashMap<>();

    public Container(Map<Key, Value> map) {
        // 在不信任客户端传入的map参数是一定不变时，通过new重新构造副本作为当前对象的内部数据，而不是this.map=map;
        this.map = new HashMap<>(map);
    }

    public Map<Key, Value> getMap() {
        // 在不信任客户端不会修改返回的map时，通过new重新构造当前对象内部数据的副本返回，而不是return map;
        return new HashMap<>(map);
    }

    public Map<Key, Value> getMapView() {
        // 或者仿照Map的keySet方法那样，返回一个不可修改的view实例给客户端，这个map不支持put（抛出异常），支持remove
        return new AbstractMap<Key, Value>() {
            @Override
            public Set<Entry<Key, Value>> entrySet() {
                return map.entrySet();
            }
        };
    }

    @Override
    public String toString() {
        return "Container{" +
                "map=" + map +
                '}';
    }
}
