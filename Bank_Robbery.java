import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = Math.max(a[0], 0L);
        
        for (int i = 2; i <= n; i++) {
            if (a[i - 1] == -1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 2] + a[i - 1], dp[i - 1]);
            }
        }
        
        System.out.println(dp[n]);
    }
}