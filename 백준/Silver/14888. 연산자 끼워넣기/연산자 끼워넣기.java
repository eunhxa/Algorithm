import java.util.Scanner;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] oper = new int[4];
        for(int i=0; i<4; i++) {
            oper[i] = sc.nextInt();
        }

        combination(arr, oper, new int[n-1], 0, n, n-1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void combination(int[] arr, int[] oper, int[] result, int cnt, int n, int r) {
        if(r == 0) {
            int answer = arr[0];
            for(int i=0; i<result.length; i++) {
                switch(result[i]) {
                    case 0:
                    answer += arr[i+1];
                    break;
                    case 1:
                    answer -= arr[i+1];
                    break;
                    case 2:
                    answer *= arr[i+1];
                    break;
                    case 3:
                    answer /= arr[i+1];
                    break;
                }
            }
            MAX = MAX < answer ? answer : MAX;
            MIN = MIN > answer ? answer : MIN;
            return;
        }

        for(int i=0; i<4; i++) {
            if(oper[i] > 0) {
                oper[i]--;
                result[cnt] = i;
                combination(arr, oper, result, cnt+1, n, r-1);
                oper[i]++;
            }
        }
    }
}