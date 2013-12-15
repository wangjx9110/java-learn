package a;

class A {
    static int a = 1;
    static void b() {
        System.out.println("This is in package A" + a);
    }
    public static void main(String[] args) {
        b();
    }
}