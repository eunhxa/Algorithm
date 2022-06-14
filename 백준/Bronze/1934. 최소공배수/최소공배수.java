import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<tc; t++) {
            String[] strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            int lcm = a*b;

            while(true) {
                int r = a%b;
                if(r == 0) break;
                a = b;
                b = r;
            }
            int gcd = b;
            lcm /= gcd;
            sb.append(lcm+"\n");
        }
        System.out.println(sb);
    }
}