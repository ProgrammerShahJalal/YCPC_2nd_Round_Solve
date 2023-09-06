import java.util.*;

class DSU {
    private long[] parent;
    private long[] parentLevel;
    private long[] parentSize;

    public DSU(int n) {
        parent = new long[n + 1];
        parentLevel = new long[n + 1];
        parentSize = new long[n + 1];
        Arrays.fill(parent, -1L);
    }

    public long find(long n) {
        if (parent[(int) n] == -1)
            return n;
        long leader = find(parent[(int) n]);
        parent[(int) n] = leader;
        return leader;
    }

    public void union(long a, long b) {
        long leaderA = find(a);
        long leaderB = find(b);
        if (leaderA != leaderB) {
            if (parentLevel[(int) leaderA] > parentLevel[(int) leaderB]) {
                parent[(int) leaderB] = leaderA;
            } else if (parentLevel[(int) leaderB] > parentLevel[(int) leaderA]) {
                parent[(int) leaderA] = leaderB;
            } else {
                parent[(int) leaderB] = leaderA;
                parentLevel[(int) leaderA]++;
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public long a, b, w;

    public Edge(long a, long b, long w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return Long.compare(this.w, other.w);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        List<Edge> v = new ArrayList<>();
        List<Edge> ans = new ArrayList<>();
        DSU dsu = new DSU(n);

        for (int i = 0; i < e; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long w = scanner.nextLong();
            v.add(new Edge(a, b, w));
        }

        Collections.sort(v);

        int cnt = 0;
        long cost = 0;

        for (Edge val : v) {
            long a = val.a;
            long b = val.b;
            long w = val.w;
            long leaderA = dsu.find(a);
            long leaderB = dsu.find(b);

            if (leaderA == leaderB) {
                cnt++;
                continue;
            }

            ans.add(val);
            cost += val.w;
            dsu.union(a, b);
        }

        boolean hs = true;

        for (int i = 1; i <= n; i++) {
            if (dsu.find(i) != dsu.find(1)) {
                hs = false;
                break;
            }
        }

        if (hs) {
            System.out.println(cnt + " " + cost);
        } else {
            System.out.println("Not Possible");
        }
    }
}
