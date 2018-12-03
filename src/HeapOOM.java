import java.util.ArrayList;
import java.util.List;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-03 17:22
 * @create: 2018-12-03 17:22
 * VM Args :-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 **/
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
