import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        String s1 = str[0]+str[1];
        String s2 = str[2]+str[3];
        
        System.out.println(Long.parseLong(s1)+Long.parseLong(s2));
    }
}