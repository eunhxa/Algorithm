import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        int[] arr = new int[n];
        for(int i=n-1; i>=0; i--) {
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<Math.pow(2, n); i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) > 0) {
                    sum += arr[j];
                }
            }
            if(sum == m) cnt++;
        }

        System.out.println(cnt);
    }
}