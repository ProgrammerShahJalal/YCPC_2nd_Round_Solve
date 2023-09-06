import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] a = new long[n];
        long[] d = new long[n + 1];

        a[0] = scanner.nextLong();
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            a[i] = scanner.nextLong();
            d[i] = a[i] - a[i - 1];
        }

        int q = scanner.nextInt();
        while (q > 0) {
            int aIndex = scanner.nextInt() ;
            int bIndex = scanner.nextInt();
            long x = scanner.nextLong();

            d[aIndex] += x;
            d[bIndex + 1] -= x;
            q--;
        }

        long[] aResult = new long[n];
        aResult[0] = d[0];
        for (int i = 1; i < n; i++) {
            aResult[i] = aResult[i - 1] + d[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(aResult[i] + " ");
        }
    }
}
