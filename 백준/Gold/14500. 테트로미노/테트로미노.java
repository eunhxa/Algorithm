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
            stk = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int max = 0;
        int sum = 0;

        for(int i=0; i<=n-4; i++) {
            for(int j=0; j<m; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i+2][j];
                sum += arr[i+3][j];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<=m-4; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i][j+3];
                if(max < sum) max = sum;
            }
        }
        // 1번 도형

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i][j+1];
                sum += arr[i+1][j+1];
                if(max < sum) max = sum;
            }
        }
        // 2번 도형

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i+2][j];
                sum += arr[i+2][j+1];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j+1];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i+1][j];
                sum += arr[i+2][j];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j+1];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j+1];
                sum += arr[i+2][j];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                sum += arr[i+1][j+2];
                sum += arr[i][j+2];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j+2];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                sum += arr[i+1][j+2];
                if(max < sum) max = sum;
            }
        }
        // 3번 도형

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j+1];
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j];
                if(max < sum) max = sum;
            }
        }


        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j+1];
                if(max < sum) max = sum;
            }
        }


        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i+1][j+1];
                sum += arr[i+1][j+2];
                if(max < sum) max = sum;
            }
        }
        // 4번 도형


        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i+1][j];
                sum += arr[i+2][j];
                sum += arr[i+1][j+1];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-3; i++) {
            for(int j=0; j<=m-2; j++) {
                sum = 0;
                sum += arr[i][j+1];
                sum += arr[i+1][j+1];
                sum += arr[i+2][j+1];
                sum += arr[i+1][j];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i+1][j];
                sum += arr[i+1][j+1];
                sum += arr[i+1][j+2];
                sum += arr[i][j+1];
                if(max < sum) max = sum;
            }
        }

        for(int i=0; i<=n-2; i++) {
            for(int j=0; j<=m-3; j++) {
                sum = 0;
                sum += arr[i][j];
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j+1];
                if(max < sum) max = sum;
            }
        }
        // 5번 도형

        System.out.println(max);
    }
}