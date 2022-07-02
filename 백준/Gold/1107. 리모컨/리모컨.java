import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];
        if (k != 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int i=0; i<k; i++) {
                arr[Integer.parseInt(stk.nextToken())] = true;
            }
        }

        int[] div = {100000, 10000, 1000, 100, 10, 1};
        int min = 99999999;
        String str = "";
        for(int i=0; i<1000000; i++) {
            boolean flag = true;
            int c = i;
            for(int j=0; j<div.length; j++) {
                if(i < div[j]) continue;
                if(arr[c/div[j]]) {
                    flag = false;
                    break;
                } 
                c %= div[j];
            }
            if(i == 0) flag = !arr[0];
            if(flag) {
                if(min > Math.abs(n-i)) {
                    min = Math.abs(n-i);
                    str = i+"";
                }
            }
        }

        int result = str.length() + min;
        System.out.println(result < Math.abs(100-n) ? result : Math.abs(100-n));
    }
}