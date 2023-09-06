import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];

            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            int k = Integer.parseInt(br.readLine().trim());
            Arrays.sort(a);
            int l = 0, r = Integer.MAX_VALUE, ans = -1;

            while (l <= r) {
                int m = l + (r - l) / 2;
                int c = 1;
                int left = a[0];

                for (int i = 1; i < n; i++) {
                    if (a[i] - left >= m) {
                        c++;
                        left = a[i];
                    }
                }

                if (c >= k) {
                    ans = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            bw.write(ans + "\n");
        }

        br.close();
        bw.close();
    }
}
