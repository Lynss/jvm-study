public enum Singleton {
    INSTANCE;
    void printMsg() {
        System.out.println("i am instance");
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.printMsg();
    }
}

