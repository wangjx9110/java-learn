import java.util.*;
class st {
    public static void main(String[] args) {
        String test = "this is a test  stri,ng";
        StringTokenizer st = new StringTokenizer(test, " ,");
        System.out.println(st.countTokens());
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            System.out.println("STR TOKEN: " + s);
            int cnt = st.countTokens();
            System.out.println("CNT: " + cnt);
        }
    }
}