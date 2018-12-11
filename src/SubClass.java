/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-10 11:03
 * @create: 2018-12-10 11:03
 **/
class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
    public static String b = "static variable or method will cause the initial of its class,and before this action ,its parent will be also inited";
}
