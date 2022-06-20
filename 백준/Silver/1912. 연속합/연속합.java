import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] nums = new int[n];
        int[] d = new int[n];

        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
            d[i] = nums[i];
        }

        for(int i=1; i<n; i++) {
            int tmp = nums[i-1] > d[i-1] ? nums[i-1] : d[i-1];
            if(tmp > 0) d[i] += tmp;
        }

        int ans = -1001;
        for(int i=0; i<n; i++) {
            if(ans < d[i]) ans = d[i];
        }
        System.out.println(ans);
    }
}