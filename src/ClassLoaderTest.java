import java.io.IOException;
import java.io.InputStream;

/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-10 15:51
 * @create: 2018-12-10 15:51
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                try (InputStream is = getClass().getResourceAsStream(fileName)) {
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        Object o = myLoader.loadClass("NotInitialization").newInstance();
        System.out.println(o.getClass());
        System.out.println(NotInitialization.class);
        System.out.println(o instanceof NotInitialization);//false
    }
}
