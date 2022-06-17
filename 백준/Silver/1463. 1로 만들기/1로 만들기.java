import java.util.Scanner;

public class Main {
    static int[] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];

        for(int i=0; i<d.length; i++) {
            d[i] = 0;
        }
        
        rec(n);
        System.out.println(d[n]);
    }

    public static int rec(int n) {
        if(n == 1) return 0;
        if(d[n] > 0) return d[n];
        
        d[n] = rec(n-1) + 1;
        if(n % 2 == 0) {
            int temp = rec(n/2) + 1;
            if(d[n] > temp) d[n] = temp;
        }
        if(n % 3 == 0) {
            int temp = rec(n/3) + 1;
            if(d[n] > temp) d[n] = temp;
        } 
        return d[n];
    }
}