import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = n+"";
        int length = str.length();
        int sum = 0;
        int[] arr = {9, 90, 900, 9000, 90000, 900000, 9000000, 90000000};

        for(int i=0; i<length-1; i++) {
            sum += arr[i] * (i+1);
        }

        int tmp = (int)Math.pow(10, length-1);
        n -= tmp;
        sum += ((n+1) * length);

        System.out.println(sum);
    }
}