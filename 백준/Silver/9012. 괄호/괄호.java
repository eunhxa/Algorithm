import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            int i = 0;
            for(; i<str.length(); i++) {
                if(str.charAt(i) == '(') {
                    s.push(str.charAt(i));
                } else {
                    if(!s.empty()) {
                        s.pop();
                    }
                    else {
                        break;
                    }
                }
            }
            if(s.empty() && (i==str.length())) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}