n = int(input())
a = list(map(int, input().split()))

dp = [0] * (n + 1)
dp[1] = max(a[0], 0)

for i in range(2, n + 1):
    if a[i - 1] == -1:
        dp[i] = dp[i - 1]
    else:
        dp[i] = max(dp[i - 2] + a[i - 1], dp[i - 1])

print(dp[n])
