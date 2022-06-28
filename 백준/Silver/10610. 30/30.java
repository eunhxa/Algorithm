import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        int[] arr = new int[n];
        
        int tmp = 0;
        for(int i=0; i<n; i++) {
            arr[i] = str.charAt(i) - '0';
            tmp += arr[i];
        }

        Arrays.sort(arr);

        if((tmp % 3 != 0) || (arr[0] != 0)) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}