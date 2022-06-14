import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int lcm = a*b;

        while(true) {
            int r = a%b;
            if(r==0) break;
            a = b;
            b = r;
        }
        int gcd = b;
        lcm /= gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}