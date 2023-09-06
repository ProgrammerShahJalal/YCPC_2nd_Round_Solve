import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long ans = (a % 1000) * (b % 1000);
            System.out.println(ans % 100);
        }
        
        scanner.close();
    }
}
