import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            int j = 0;

            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                j = str.charAt(i)+13;
                if(j > 'z') j = j-26;
            } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                j = str.charAt(i)+13;
                if(j > 'Z') j = j-26;
            } else {
                j = str.charAt(i);
            }
            sb.append((char)j);
        }
        System.out.println(sb);
    }
}