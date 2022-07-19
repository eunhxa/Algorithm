#include <iostream>
#include <queue>
using namespace std;

int main() {
	queue<pair<int, int>> q_water;
	queue<pair<int, int>> q_hedgehog;

	int R, C, cnt = 0;
	int dx[] = { 0, 0, -1, 1 };
	int dy[] = { -1, 1, 0, 0 };
	int gx, gy;
	bool flag = false;
	char map[51][51];
	int visit[51][51] = { 0, };

	cin >> R >> C;

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			cin >> map[i][j];
			if (map[i][j] == '*') {
				q_water.push({ i,j });
				visit[i][j] = 1;
			}
			if (map[i][j] == 'S') {
				q_hedgehog.push({ i,j });
				visit[i][j] = 1;
			}//고슴도치
			if (map[i][j] == 'D') { //비버의 굴
				gx = i, gy = j; //이부분 체크하기
			}
		}
	}

	while (!q_hedgehog.empty()) {
		/*이부분부터 반복하면 됨*/
		int size = q_water.size();
		while (size--) {
			auto now = q_water.front();
			q_water.pop();
			int x = now.first, y = now.second;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i]; int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (map[nx][ny] == '.') {
					q_water.push({ nx,ny });
					visit[nx][ny] = 1;
					map[nx][ny] = '#'; //물이 찰 예정인 곳
				}
			}
		}

		int hsize = q_hedgehog.size();

		while (hsize--) {
			auto set = q_hedgehog.front();
			if (set.first == gx && set.second == gy) {
				flag = true;
				break;
			}
			q_hedgehog.pop();
			int x = set.first, y = set.second;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i]; int ny = y + dy[i];
				if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
				if (((map[nx][ny] == '.') || (map[nx][ny] == 'D')) && visit[nx][ny] == 0) {
					q_hedgehog.push({ nx, ny });
					visit[nx][ny] = 1;
				}
			}
			map[x][y] = '.';
		}
		if (flag) break;
		cnt++;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '#') map[i][j] = '*';
			}
		} //물이 흐른걸로 바꾸기
	} 

	flag ? cout << cnt : cout << "KAKTUS";

	return 0;
}