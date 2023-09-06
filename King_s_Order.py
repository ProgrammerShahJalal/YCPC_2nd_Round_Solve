class DSU:
    def __init__(self, n):
        self.parent = [-1] * (n + 1)
        self.parentLevel = [0] * (n + 1)
        self.parentSize = [1] * (n + 1)

    def find(self, n):
        if self.parent[n] == -1:
            return n
        leader = self.find(self.parent[n])
        self.parent[n] = leader
        return leader

    def union(self, a, b):
        leaderA = self.find(a)
        leaderB = self.find(b)
        if leaderA != leaderB:
            if self.parentLevel[leaderA] > self.parentLevel[leaderB]:
                self.parent[leaderB] = leaderA
            elif self.parentLevel[leaderB] > self.parentLevel[leaderA]:
                self.parent[leaderA] = leaderB
            else:
                self.parent[leaderB] = leaderA
                self.parentLevel[leaderA] += 1

class Edge:
    def __init__(self, a, b, w):
        self.a = a
        self.b = b
        self.w = w

def main():
    n, e = map(int, input().split())
    v = []
    ans = []
    dsu = DSU(n)
    for _ in range(e):
        a, b, w = map(int, input().split())
        v.append(Edge(a, b, w))
    v.sort(key=lambda x: x.w)
    cnt = 0
    cost = 0
    for val in v:
        a = val.a
        b = val.b
        w = val.w
        leaderA = dsu.find(a)
        leaderB = dsu.find(b)
        if leaderA == leaderB:
            cnt += 1
            continue
        ans.append(val)
        cost += val.w
        dsu.union(a, b)
    hs = all(dsu.find(i) == dsu.find(1) for i in range(1, n + 1))
    if hs:
        print(cnt, cost)
    else:
        print("Not Possible")

if __name__ == "__main__":
    main()
