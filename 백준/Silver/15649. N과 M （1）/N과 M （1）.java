import java.util.Scanner;

public class Main {
    static boolean[] arr;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new boolean[n+1];
        result = new int[m];

        go(0, n, m);
    }

    public static void go(int index, int n, int m) {
        if(index == m) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<m; i++) {
                sb.append(result[i]+" ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=1; i<=n; i++) {
            if(arr[i]) continue;
            arr[i] = true;
            result[index] = i;
            go(index+1, n, m);
            arr[i] = false;
        }
    }
}