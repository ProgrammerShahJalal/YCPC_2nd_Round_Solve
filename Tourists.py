def check(a, n, k, mid):
    count = 1
    lp = a[0]
    
    for i in range(1, n):
        if a[i] - lp >= mid:
            count += 1
            lp = a[i]
    ans = count >= k
    return ans
t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    k = int(input())

    a.sort()
    l, r, ans = 0, a[n - 1] - a[0], -1

    while l <= r:
        m = l + (r - l) // 2
        if check(a, n, k, m):
            ans = m
            l = m + 1
        else:
            r = m - 1

    print(ans)
