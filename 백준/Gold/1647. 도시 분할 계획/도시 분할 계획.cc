#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int* parent;

int findRoot(int x) {
	if (parent[x] == x)return x;
	else return parent[x] = findRoot(parent[x]);
}

void uni(int x, int y) {
	int rootX = findRoot(x);
	int rootY = findRoot(y);
	parent[rootY] = rootX;
}

int main() {
	int n, m;
	cin >> n >> m;

	priority_queue<pair<int, pair<int, int>>>pq;

	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		pq.push({ -c, {a,b} });
	}

	parent = new int[n + 1];
	for (int i = 1; i <= n; i++)parent[i] = i;
	int count = 0;
	int sum = 0;
	while (count < n - 2) {
		int node1 = pq.top().second.first;
		int node2 = pq.top().second.second;
		if (findRoot(node1) != findRoot(node2)) {
			sum += -pq.top().first;
			count++;
			uni(node1, node2);
		}
		pq.pop();
	}
	cout << sum;
}