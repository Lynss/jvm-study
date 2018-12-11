/**
 * @program: jvm-study
 * @author: longyun
 * @update 2018-12-10 10:30
 * @create: 2018-12-10 10:30
 **/

class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static final String a = "final will be push into the constant pool,so the super class wont init";
    public static String c = "static variable or method will cause the initial of its class,and before this action ,its parent will be also inited";
}
