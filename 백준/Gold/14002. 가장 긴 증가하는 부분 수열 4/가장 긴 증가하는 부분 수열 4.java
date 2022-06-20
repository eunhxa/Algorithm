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
        int[] m = new int[n];
        for(int i=0; i<n; i++) {
            d[i] = 1;
            m[i] = i;
        }


        for(int i=0; i<n; i++) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    if(d[j]+1 > d[i]) {
                        d[i] = d[j]+1;
                        m[i] = j;
                    }
                }
            }
        }

        int result = 0;
        int tmp = 0;
        for(int i=0; i<n; i++) {
            if(d[i] > result) { 
                result = d[i];
                tmp = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result; i++) {
            sb.insert(0, nums[tmp]+" ");
            tmp = m[tmp];
        }

        System.out.println(result);
        System.out.println(sb);
    }
}