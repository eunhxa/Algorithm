import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;
        for(int i=n; i>0; i--) {
            res *= i;
        }
        System.out.println(res);
    }
}