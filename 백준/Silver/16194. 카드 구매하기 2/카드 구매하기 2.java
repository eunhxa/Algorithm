import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] p = new int[n+1];
        int[] d = new int[n+1];

        d[0] = 0;
        p[0] = 0;

        for(int i=1; i<=n; i++) {
            d[i] = p[i] = Integer.parseInt(strs[i-1]);
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<n; j++) {
                if(i<=j) continue;
                d[i] = Math.min(d[i], d[i-j]+p[j]);
            }
        }
        System.out.println(d[n]);
    }
}