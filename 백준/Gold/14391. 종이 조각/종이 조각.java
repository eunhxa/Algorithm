import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        int max = 0;
        for(int i=0; i<(1<< (n*m)); i++) {
            int sum = 0;

            for(int j=0; j<n; j++) { // 가로
                int tmp = 0;
                for(int k=0; k<m; k++) {
                    if((i & (1 << (j*m+k))) == 0) tmp = tmp * 10 + arr[j][k];
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }
                sum += tmp;
            }

            for(int k=0; k<m; k++) { // 세로
                int tmp = 0;
                for(int j=0; j<n; j++) {
                    if((i & (1 << (j*m+k))) > 0) tmp = tmp * 10 + arr[j][k];
                    else {
                        sum += tmp;
                        tmp = 0;
                    }
                }
                sum += tmp;
            }
            max = max > sum ? max : sum;
        }
        System.out.println(max);
    }
}