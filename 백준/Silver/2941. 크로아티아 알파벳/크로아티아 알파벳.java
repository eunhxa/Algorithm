import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        String[] strs = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int cnt = 0;
        for(int i=0; i<strs.length; i++) {
            int originLength = inputStr.replace(" ", "").length();
            inputStr = inputStr.replace(strs[i], " ");
            int n = originLength - inputStr.replace(" ", "").length();
            cnt += (n/strs[i].length());
        }
        inputStr = inputStr.replace(" ", "");
        cnt += inputStr.length();
        System.out.println(cnt);
    }   
}