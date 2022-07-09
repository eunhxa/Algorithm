import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String command = stk.nextToken();
            
            int num = 0;
            if((!command.equals("all")) && (!command.equals("empty"))) {
                num = Integer.parseInt(stk.nextToken());
            }

            switch(command) {
                case "check":
                if((answer & (1 << num)) != 0) sb.append("1\n");
                else sb.append("0\n");
                break;
                case "add":
                answer = (answer | (1 << num));
                break;
                case "remove":
                answer = (answer & (~(1 << num)));
                break;
                case "toggle":
                answer = (answer ^ (1 << num));
                break;
                case "all":
                answer = (answer | ~(0));
                break;
                case "empty":
                answer = (answer & 0);
                break;
                default:
                break;
            }
        }
        System.out.println(sb);
    }
}