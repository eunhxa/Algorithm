import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] check = new boolean[n+1];
        int[] arr = {1000, 100, 10, 1};

        for(int i=0; i<=n; i++) {
            int[] num = new int[4];
            int tmp = i;
            for(int j=0; j<4; j++) {
                num[j] = tmp/arr[j];
                tmp %= arr[j];
            }
            int a = 10;
            for(int j=0; j<3; j++) {
                if(a == 10 && num[j] == 0) continue;
                else {
                    tmp = num[j] - num[j+1];
                    if(a == 10) a = tmp;
                    else {
                        if(a != tmp) check[i] = true;
                        break;
                    }    
                }
            }
        }
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(!check[i]) cnt++; 
        }
        System.out.println(cnt);
    }
}