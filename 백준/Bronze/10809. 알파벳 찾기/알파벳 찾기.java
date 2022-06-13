import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];

        char c = 'a';
        for(int i=0; i<26; i++) {
            arr[i] = str.indexOf(c);
            c++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}