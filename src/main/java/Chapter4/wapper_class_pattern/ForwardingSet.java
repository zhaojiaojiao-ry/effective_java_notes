package Chapter4.wapper_class_pattern;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// 在Forward类中，1. 将Set对象作为成员变量，2. 实现Set接口的方法，调用成员变量的对应方法
public class ForwardingSet<E> implements Set<E> {// 继承接口
    private Set<E> set;// 作为成员变量

    public ForwardingSet(Set<E> set) {// 用set实例初始化，可以支持set的不同实现
        this.set = set;
    }

    @Override
    public int size() {// 需要重新写set接口的方法，直接调用set成员变量的对应方法即可
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return set.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
