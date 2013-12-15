public class reload {
    public static void main(String args[]) {
        Area a = new Area();
        float area = a.getArea(10);
        System.out.println(area);
        double area2 = a.getArea(10, 11);
        System.out.println(area2);
    }
}

class Area {
    static int stc = 1;
    float getArea(float r) {
        System.out.println(this.stc + " !");
        return 3.14f * r * r;
    }
    double getArea(float x, int y) {
        System.out.println(Area.stc + " !");
        return x * y;

        char a[] = {'L', 'i', 'm', 'e', 'n'};
        String b = "Limen";
    }
}