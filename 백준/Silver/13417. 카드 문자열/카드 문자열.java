import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb1 = new StringBuilder();
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(st.nextToken());
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                if(sb2.charAt(0) >= str.charAt(0)) {
                    sb2.insert(0, str);
                } else {
                    sb2.append(str);
                }
            }

            sb1.append(sb2+"\n");
        }
        System.out.println(sb1);
    }
}