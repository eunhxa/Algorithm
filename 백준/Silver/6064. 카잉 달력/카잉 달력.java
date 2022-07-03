import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());    
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            int num1 = x;
            int num2 = x;
            int cnt = x;
            boolean flag = false;
            for(int i=0; i<n; i++) {
                while(num1 > m) num1 -= m;
                while(num2 > n) num2 -= n;

                if(num1 == x && num2 == y) {
                    flag = true;
                    break;
                }
                num1 += m;
                num2 += m;
                cnt += m;
            }

            sb.append(flag ? cnt : "-1");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}