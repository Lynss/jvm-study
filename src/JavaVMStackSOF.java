/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-03 17:43
 * @create: 2018-12-03 17:43
 * -Xss128k
 **/
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLength:"+javaVMStackSOF.stackLength);
            throw e;
        }
    }
}
