class E {
    public static void main(String args[]) {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            int temp = 1;
            for (int j = i; j >=1; j--) {
                temp *= j;
            }
            System.out.println(temp);
            sum += temp;
        }
        System.out.println(sum);
        prime();
        String a = "10";
        int m = Integer.parseInt(a + "00");
        System.out.println(m);
    }
    static void prime() {
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = i-1; j >=2; j--) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}