package Chapter4.wapper_class_pattern;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WapperSetV2<E> {
    private Set<E> set;
    private int addCount = 0;

    public WapperSetV2(Set<E> set) {
        this.set = set;
    }

    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }
}
