import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt2 = 0;
        int cnt5 = 0;
        
        for(int i=1; i<=n; i++) {
            int tmp = i;
            while(tmp%2 == 0) {
                tmp /= 2;
                cnt2++;
            }
            while(tmp%5 == 0) {
                tmp /= 5;
                cnt5++;
            }
        }

        System.out.println(cnt2 >= cnt5 ? cnt5 : cnt2);
    }
}