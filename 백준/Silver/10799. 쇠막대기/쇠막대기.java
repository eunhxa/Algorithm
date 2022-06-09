import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int n = 0;
        int num = 0;

        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == '(') {
                if(str.charAt(i+1) == ')') {
                    cnt += n;
                    i++;
                } else {
                    num++;
                    n++;
                }
            } else {
                n--;
            }
        }
        System.out.println(cnt+num);
    }
}