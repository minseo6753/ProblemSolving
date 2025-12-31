#include<iostream>
#include<vector>
#include<queue>
using namespace std;

class Group {
	int* parent;

public:
	Group(int size) {
		parent = new int[size + 1];
		for (int i = 1; i <= size; i++)parent[i] = i;
	}

	int findRoot(int x) {
		if (parent[x] == x)return x;
		else return parent[x] = findRoot(parent[x]);
	}

	void uni(int x, int y) {
		int rootX = findRoot(x);
		int rootY = findRoot(y);
		parent[rootY] = rootX;
	}
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	priority_queue<pair<int, pair<int, int>>>pq;

	for (int i = 0; i < m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		pq.push({ -c, {a,b} });
	}

	Group g(n);
	int count = 0;
	int sum = 0;
	while (count < n - 2) {
		int node1 = pq.top().second.first;
		int node2 = pq.top().second.second;
		if (g.findRoot(node1) != g.findRoot(node2)) {
			sum += -pq.top().first;
			count++;
			g.uni(node1, node2);
		}
		pq.pop();
	}
	cout << sum;
}