# include <bits/stdc++.h>

using namespace std;

// Complete the makeAnagram function below.

int makeanagram(string a, string b) {
    auto count = 0;
    vector<int> freq(26, 0);
    for (auto c : a) { ++freq[c - 'a']; }
    for (auto c : b) { --freq[c - 'a']; }
    for (auto val : freq) { count += abs(val); }
    return count;
}



int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string a;
    getline(cin, a);

    string b;
    getline(cin, b);

    int res = makeanagram(a, b);

    fout << res << "\n";

    fout.close();

    return 0;
}
