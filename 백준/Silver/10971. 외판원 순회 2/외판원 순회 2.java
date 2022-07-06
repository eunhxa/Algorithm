import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static boolean next_permutation(int n) {
        int j = -1;
        for(int i=n-1; i>=1; i--) {
            if(arr[i] > arr[i-1]) {
                j = i-1;
                break;
            }
        }
        if(j != -1) {
            for(int i=n-1; i>j; i--) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    break;
                }
            }
            for(int i=1; i<n; i++) {
                if(j+i >= n-i) break;
                int tmp = arr[j+i];
                arr[j+i] = arr[n-i];
                arr[n-i] = tmp;   
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());   
        int[][] d = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                d[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i;
        }

        int min = Integer.MAX_VALUE;
        do {
            int sum = 0;
            boolean ok = true;
            for(int i=0; i<n-1; i++) {
                if(d[arr[i]][arr[i+1]] == 0) ok = false;
                sum += d[arr[i]][arr[i+1]];
            }
            if(ok && (d[arr[n-1]][arr[0]] != 0)) { 
                sum += d[arr[n-1]][arr[0]];
                min = min <= sum ? min : sum;
            }
        } while(next_permutation(n));
        System.out.println(min);
    }
}