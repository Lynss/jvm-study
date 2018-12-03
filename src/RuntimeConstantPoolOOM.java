import java.util.ArrayList;
import java.util.List;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-03 17:58
 * @create: 2018-12-03 17:58
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk1.6前会导致运行时常量池所在的方法去 out of memory ...
 **/
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
