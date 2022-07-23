import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t<=tc; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String str1 = stk.nextToken();
            String str2 = stk.nextToken();
            String str3 = stk.nextToken();

            int cnt = 0;
            boolean ok = false;
            for(int i=0; i<str3.length(); i++) {
                char c = str3.charAt(i);
                if(c == str1.charAt(cnt)) {
                    cnt++;
                }
                if(cnt == str1.length()) {
                    ok = true;
                    break;
                }
            }
            if(!ok) {
                System.out.println("Data set "+t+": no");
                continue;
            }

            ok = false;
            cnt = 0;

            for(int i=0; i<str3.length(); i++) {
                char c = str3.charAt(i);
                if(c == str2.charAt(cnt)) {
                    cnt++;
                }
                if(cnt == str2.length()) {
                    ok = true;
                    break;
                }
            }
            if(!ok) {
                System.out.println("Data set "+t+": no");
                continue;
            }

            char[] char1 = str3.toCharArray();
            int len = str1.length() + str2.length();
            char[] char2 = new char[len];
            for(int i=0; i<str1.length(); i++) {
                char2[i] = str1.charAt(i);
            }
            for(int i=str1.length(); i<char2.length; i++) {
                char2[i] = str2.charAt(i-str1.length());
            }


            Arrays.sort(char1);
            Arrays.sort(char2);
            for(int i=0; i<len; i++) {
                if(char1[i] != char2[i]) {
                    ok = false;
                    break;
                }
            }

            if(!ok) System.out.println("Data set "+t+": no");
            else System.out.println("Data set "+t+": yes");
        }
    }
}