import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int j = -1;
        for(int i=n-1; i>=1; i--) {
            if(arr[i-1] > arr[i]) {
                j = i-1;
                break;
            }
        }
        if(j != -1) {
            for(int i=n-1; i>j; i--) {
                if(arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<=j; i++) {
                sb.append(arr[i]+" ");
            }
            for(int i=n-1; i>j; i--) {
                sb.append(arr[i]+" ");
            }
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }
    }
}