t = int(input())

for _ in range(t):
    a, b = map(int, input().split())
    ans = (a % 1000) * (b % 1000)
    print(ans % 100)