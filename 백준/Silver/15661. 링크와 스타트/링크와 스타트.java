import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int sum;
    static int min;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                    arr[i][j] += Integer.parseInt(stk.nextToken());
            }
        }

        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();
        go(0, team1, team2);
        System.out.println(min);
    }

    public static void go(int index, ArrayList<Integer> team1, ArrayList<Integer> team2) {
        if(index == n) {
            if(team1.size() < 1) return;
            if(team2.size() < 1) return;

            int t1 = 0;
            int t2 = 0;
            for (int i=0; i<team1.size(); i++) {
                for (int j=0; j<team1.size(); j++) {
                    if (i == j) continue;
                    t1 += arr[team1.get(i)][team1.get(j)];
                }
            }
            for (int i=0; i<team2.size(); i++) {
                for (int j=0; j<team2.size(); j++) {
                    if (i == j) continue;
                    t2 += arr[team2.get(i)][team2.get(j)];
                }
            }
            int diff = Math.abs(t1-t2);
            min = min < diff ? min : diff;
            return;
        }

        team1.add(index);
        go(index+1, team1, team2);
        team1.remove(team1.size()-1);

        team2.add(index);
        go(index+1, team1, team2);
        team2.remove(team2.size()-1);
    }
}