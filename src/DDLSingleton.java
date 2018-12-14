/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-13 16:28
 * @create: 2018-12-13 16:28
 **/
public class DDLSingleton {
    public static volatile DDLSingleton instance;

    public static DDLSingleton getInstance() {
        if (instance == null) {
            synchronized (DDLSingleton.class) {
                if (instance == null) {
                    instance = new DDLSingleton();
                }
            }
        }
        return instance;
    }
}
