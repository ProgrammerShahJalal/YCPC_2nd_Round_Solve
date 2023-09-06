#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main()
{
    ll t;
    cin >> t;
    while (t--)
    {
        ll a, b;
        cin >> a >> b;
        ll ans = (a % 1000) * (b % 1000);
        cout << (ans % 100) << endl;
    }
    return 0;
}