import java.lang.reflect.Proxy;
import java.util.Iterator;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-04 11:43
 * @create: 2018-12-04 11:43
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 * -XX:MetaspaceSize (在现在jdk中用metaspace代替了永久代)
 **/
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while (true){
            //字节码增强貌似这里不能运行
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,objects));
//            enhancer.create();
        }
    }
}
