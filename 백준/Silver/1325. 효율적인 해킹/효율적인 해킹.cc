#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M;
vector<int>* trust;
bool* visited;
int* cnt;

void BFS(int start) {
    queue<int> q;
    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int now = q.front();
        q.pop();

        for (int next : trust[now]) {
            if (!visited[next]) {
                q.push(next);
                cnt[next]++;
                visited[next] = true;
            }
        }
    }
}

void solution() {
    cnt = new int[N + 1]();
    for (int i = 1; i <= N; i++) {
        fill(visited, visited + N + 1, false);
        BFS(i);
    }

    int maxCount = 0;
    for (int i = 1; i <= N; i++) {
        maxCount = max(maxCount, cnt[i]);
    }
    for (int i = 1; i <= N; i++) {
        if (maxCount == cnt[i])
            cout << i << " ";
    }
}

void make() {
    cin >> N >> M;

    trust = new vector<int>[N + 1];
    visited = new bool[N + 1]();

    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        trust[u].push_back(v);
    }
}

int main() {
    make();
    solution();

    delete[] trust;
    delete[] visited;
    delete[] cnt;

    return 0;
}