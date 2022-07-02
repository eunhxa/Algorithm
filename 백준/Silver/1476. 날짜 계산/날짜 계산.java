import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int tmpE = 1;
        int tmpS = 1;
        int tmpM = 1;

        int cnt = 1;
        while(true) {
            if(tmpE == e && tmpM == m && tmpS == s) {
                break;
            }

            cnt++;
            tmpE++;
            tmpS++;
            tmpM++;
            if(tmpE == 16) tmpE = 1;
            if(tmpS == 29) tmpS = 1;
            if(tmpM == 20) tmpM = 1;
        }
        System.out.println(cnt);
    }
}