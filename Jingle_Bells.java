import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        long line = (n + 1) / 2 + 5;
        long sp = line - 1;
        long st = 1;

        for (long i = 1; i <= line; i++) {
            for (long j = 1; j <= sp; j++) {
                System.out.print(" ");
            }
            for (long j = 1; j <= st; j++) {
                System.out.print("*");
            }
            sp--;
            st += 2;
            System.out.println();
        }

        long start = ((line * 2) - 1 - n) / 2;

        for (long i = 1; i <= 5; i++) {
            for (long j = 1; j <= start; j++) {
                System.out.print(" ");
            }
            for (long j = 1; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
