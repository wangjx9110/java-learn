class staticThis {
    public static void main(String args[]) {
        A aa = new A();
        aa.func();
        System.out.println(aa.m);
        System.out.println(aa.n);
    }
}

class A {
    static int m = 1;
    int n = 2;
    void func() {
        this.n = 200;
        this.m = 100;
    }
}