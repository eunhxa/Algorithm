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

        int[] inc = new int[n+1];
        int[] dec = new int[n+1];

        for(int i=0; i<=n; i++) {
            inc[i] = 1;
            dec[i] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
                if(nums[j] < nums[i] && inc[j] + 1 > inc[i]) {
                    inc[i] = inc[j] + 1;
                }
            }
        }

        for(int i=n; i>=2; i--) {
            for(int j=1; j<i; j++) {
                if(nums[j] > nums[i] && dec[i] + 1 > dec[j]) {
                    dec[j] = dec[i] + 1;
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(inc[i] + dec[i] > answer) answer = inc[i] + dec[i] - 1;
        }

        System.out.println(answer);
    }
}