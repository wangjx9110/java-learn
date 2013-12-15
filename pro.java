class Pro {
    private void sayHello() {
        System.out.println("Hello! this is private");
    }
    public static void main(String[] args) {
        Pro p = new Pro();
        p.sayHello();
    }
}

class X {
    private void m() {
        Pro p = new Pro();
        p.sayHello();
    }
}