import java.util.*;

class Trailing_Zeroes_in_Factorial {
    public static void main(String args[]) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res = res + n / i;
        }
        System.out.println(res);
        sc.close();
    }
}