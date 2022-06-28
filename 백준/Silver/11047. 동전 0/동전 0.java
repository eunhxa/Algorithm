import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        int[] coin = new int[n];
        for(int i=0; i<n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i=n-1; i>=0; i--) {
            cnt += k/coin[i];
            k %= coin[i];
        }

        System.out.println(cnt);
    }
}