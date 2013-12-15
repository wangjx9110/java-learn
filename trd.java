public class trd {
    public static void main(String[] args) {
        Lefthand left = new Lefthand();
        Righthand right = new Righthand();

        left.start();
        right.start();

        for (int i = 1; i <= 9; i++) {
            System.out.println("MainThread");
        }
    }
}

class Lefthand extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println("Lefthand");
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }
}

class Righthand extends Thread {
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println("Righthand");
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }
}