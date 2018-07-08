package Chapter10.lazy_initialization;

public class Client {
    public static void main(String[] args) {
        SingletonV1 single1 = SingletonV1.getInstance();
        SingletonV1 single2 = SingletonV1.getInstance();
        if (single1 == single2) {
            System.out.println("the same singleton");
        }

        SingletonV2 single3 = SingletonV2.getInstance();
        SingletonV2 single4 = SingletonV2.getInstance();
        if (single3 == single4) {
            System.out.println("the same singleton");
        }
    }
}
