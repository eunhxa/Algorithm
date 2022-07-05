import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        int max = 0;
        do {
            int sum = 0;
            for(int i=0; i<=n-2; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            max = max > sum ? max : sum;
        } while(next_permutation(n));
        System.out.println(max);
    }
}