def main():
    n = int(input())
    a = list(map(int, input().split()))
    d = [0] * (n + 1)

    d[0] = a[0]
    for i in range(1, n):
        d[i] = a[i] - a[i - 1]

    q = int(input())
    while q > 0:
        a, b, x = map(int, input().split())
        d[a] += x
        d[b+1] -= x
        q -= 1

    a_result = [0]
    a_result[0] = d[0]
    for i in range(1, n):
        a_result.append(a_result[i-1] + d[i])

    for i in range(0, n):
        print(a_result[i], end=" ")


if __name__ == "__main__":
    main()
