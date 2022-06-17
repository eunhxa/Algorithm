#include <iostream>
using namespace std;

int main() {
	int dp[10001];
	int num;
	int ans = 0;
	cin >> num;
	int* price = new int[num];

	for (int i = 0; i < num; i++) {
		cin >> price[i];
	}

	dp[0] = 0;
	dp[1] = price[0];

	for (int i = 2; i < num+1; i++) {
		for (int j = 1; j < (i / 2)+1; j++) {
			int temp;

			temp = dp[j] + dp[i - j];
			ans = temp > ans ? temp : ans;
		}
		dp[i] = ans > price[i - 1] ? ans : price[i - 1];
	}

	cout << dp[num];

	return 0;
}