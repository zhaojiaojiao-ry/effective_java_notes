package Chapter7.ensure_immutable;

public class Value {
    private int data;

    public Value() {
    }

    public Value(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Value{" +
                "data=" + data +
                '}';
    }
}
