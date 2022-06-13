import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] c = new int[26];
        
        for(int i=0; i<26; i++) {
            c[i] = 0;
        }

        for(int i=0; i<str.length(); i++) {
            c[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++) {
            sb.append(c[i] + " ");
        }

        System.out.println(sb);
    }
}