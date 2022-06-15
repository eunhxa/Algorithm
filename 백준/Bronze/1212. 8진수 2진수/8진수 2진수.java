import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = sc.nextLine();

        if(str.equals("0")) {
            System.out.println("0");
            return;
        }

        String[] strs = {"000", "001", "010", "011", "100", "101", "110", "111"};
        for(int i=0; i<str.length(); i++) {
            sb.append(strs[str.charAt(i)-'0']);
        }
        while(sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}