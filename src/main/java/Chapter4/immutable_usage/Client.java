package Chapter4.immutable_usage;

public class Client {
    public static void main(String[] args) {
        MyBoolean myBoolean = MyBoolean.valueOf(true);
        System.out.println(myBoolean);

        MyBoolean trueBoolean = MyBoolean.TRUE;
        MyBoolean trueBooleanV2 = MyBoolean.TRUE;
        if (trueBoolean == trueBooleanV2) {
            System.out.println("is the same true boolean");
        }
    }
}
