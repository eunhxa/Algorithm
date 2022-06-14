import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int cnt = 0;
        
        for(int t=0; t<tc; t++) {
            boolean flag = true;
            int n = sc.nextInt();
            if(n < 2) {
                flag = false;
            }
            for(int i=2; i*i<=n; i++) {
                if(n%i == 0) flag = false;
            }
            if(flag) cnt++;
        }
        System.out.println(cnt);
    }
}