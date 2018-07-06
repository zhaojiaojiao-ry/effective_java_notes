package Chapter4.wapper_class_pattern;


// 想实现一个基于set，又增加了元素添加次数记录功能的类，wapperSet
// 可选的3种方法
// 1. 定义新类，继承一个指定的set实现类，如hashset，重写hashset类的add和addAll方法。
// 问题：hashset实现中addAll中调用了add，这用隐含的self-use无法被外部得知，会造成问题。
// 只能继承set的一个具体实现类，无法通用到set全部实现类。

// 2. 定义新类WapperSetV2，将实现了set接口的实例作为成员变量，并增加额外的属性和功能。
// 问题：如果还有其他类想要扩展Set类，也需要重复这样实现。
// 没有办法借助Set的接口定义，直接重写Set接口定义的方法，必须自己实现对着set的接口定义重新定义并实现。

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 3. 定义ForwardSet类，实现set接口，并将实现了set接口的实例作为成员变量。
// 定义WapperSetV3类，继承ForwardSet类，并增加额外的属性和功能，可以重写set类的方法。
// 问题：需要定义ForwardSet类，实现一遍set接口的方法。
// 好处：定义的ForwardSet类作为父类，可以允许多个类扩展ForwardSet类，复用。
// 借助了Set的接口定义，直接重写Set接口定义的方法达到新功能。
public class Client {
    public static void main(String[] args) {
        WapperSetV3<Integer> wapperSetV3 = new WapperSetV3<>(new HashSet<>());
        wapperSetV3.add(1);
        wapperSetV3.add(2);
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        wapperSetV3.addAll(list);
        System.out.println(wapperSetV3.toString());
    }

}
