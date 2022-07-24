import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] room = new int[n];
        for(int i=0; i<n; i++) {
            room[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        int c = sc.nextInt();

        long cnt = 0;
        for(int i=0; i<n; i++) {
            room[i] -= b;
            cnt++;
            if(room[i] <= 0) continue;
            cnt += (room[i]-1)/c + 1;
        }

        System.out.println(cnt);
    }
}