package Chapter5.heterogeneous_container;

import java.util.HashMap;
import java.util.Map;

public class HeterogeneousContainer{
    private Map<Class<?>, Object> container = new HashMap<>();

    public void put(Object obj) {
        container.put(obj.getClass(), obj);
    }

    public <T> T get(Class<T> classType) {
        if (container.containsKey(classType)) {
            Object obj = container.get(classType);
            return classType.cast(obj);
        }
        return null;
    }

    @Override
    public String toString() {
        return "HeterogeneousContainer{" +
                "container=" + container +
                '}';
    }
}
