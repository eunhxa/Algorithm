import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        int[] d = new int[n];
        for(int i=0; i<n; i++) {
            d[i] = 1;
        }

        for(int i=0; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    if(d[j]+1 > d[i]) {
                        d[i] = d[j]+1;
                    }
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            if(d[i] > result) result = d[i];
        }

        System.out.println(result);
    }
}