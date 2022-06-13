import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = new String[str.length()];

        for(int i=0; i<str.length(); i++) {
            strs[i] = str.substring(i);
        }

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            sb.append(strs[i]+'\n');
        }
        System.out.println(sb);
    }
}