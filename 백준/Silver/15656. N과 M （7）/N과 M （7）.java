import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        check = new boolean[n];
        arr = new int[n];
        result = new int[m];

        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        go(0, n, m);
        System.out.println(sb);
    }

    public static void go(int index, int n, int m) {
        if(index == m) {
            for(int i=0; i<m; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++) {
            check[i] = true;
            result[index] = arr[i];
            go(index+1, n, m);
            check[i] = false;
        }
    }
}