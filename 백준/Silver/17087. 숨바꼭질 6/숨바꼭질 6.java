import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            arr[i] = arr[i] > s ? arr[i]-s : s-arr[i];
        }

        for(int i=0; i<n-1; i++) {
            int a = arr[i];
            int b = arr[i+1];
            while(true) {
                int r = a%b;
                if(r == 0) break;
                a = b;
                b = r;
            }
            arr[i+1] = b;
        }
        System.out.println(arr[n-1]);
    }
}