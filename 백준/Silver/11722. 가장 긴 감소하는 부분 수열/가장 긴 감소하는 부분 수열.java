import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] strs = br.readLine().split(" ");
        int[] nums = new int[n+1];

        for(int i=0; i<n; i++) {
            nums[i+1] = Integer.parseInt(strs[i]);
        }

        int[] d = new int[n+1];
        d[1] = 1;
        for(int i=2; i<=n; i++) {
            d[i] = 1;
            for(int j=1; j<i; j++) {
                if(nums[j] > nums[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(answer < d[i]) answer = d[i];
        }
        System.out.println(answer);
    }
}