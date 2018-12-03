/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-03 17:50
 * @create: 2018-12-03 17:50
 * -Xss2M
 **/
public class JavaVMStackOOM {
    public void stackLeakByThread(){
        while (true){
            new Thread(()->{while (true){}}).start();
        }
    }
    public static void main(String[] args) throws Throwable{
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
