public class NotInitialization {
    public static void main(String[] args) {
        SuperClass[] t = new SuperClass[10];//SuperClass won't init
        System.out.println(SubClass.a);
        System.out.println(SubClass.c); //SuperClass init and SubClass may not be inited because jvm didn't command it,and by default it won't be inited ,you can use -XX:+TraceClassLoading
//        System.out.println(SubClass.b); //SuperClass init SubClass init
    }
}
