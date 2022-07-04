import java.util.Scanner;

public class Main {
    static boolean[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new boolean[n+1];
        result = new int[m];

        go(0, n, m);
        System.out.println(sb);
    }

    public static void go(int index, int n, int m) {
        if(index == m) {
            for(int i=0; i<m; i++) {
                sb.append(result[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++) {
            if(index >= 1 && i < result[index-1]) continue;
            arr[i] = true;
            result[index] = i;
            go(index+1, n, m);
            arr[i] = false;
        }
    }
}