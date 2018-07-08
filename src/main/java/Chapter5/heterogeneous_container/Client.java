package Chapter5.heterogeneous_container;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        HeterogeneousContainer container = new HeterogeneousContainer();
        container.put(new Integer(1));
        container.put(new String("abc"));
        container.put(new Date());
        System.out.println(container);

        System.out.println(container.get(Integer.class));
        System.out.println(container.get(String.class));
        System.out.println(container.get(Date.class));
    }
}
