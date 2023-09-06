#include <bits/stdc++.h>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++)
            cin >> a[i];
        cin >> k;
        sort(a, a + n);
        int l = 0, r = INT_MAX, ans = -1;
        while (l <= r)
        {
            int m = l + (r - l) / 2;
            int c = 1, left = a[0];
            for (int i = 1; i < n; i++)
            {
                if (a[i] - left >= m)
                {
                    c++;
                    left = a[i];
                }
            }
            if (c >= k)
            {
                ans = m;
                l = m + 1;
            }
            else
            {
                r = m - 1;
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}