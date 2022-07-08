import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static boolean[] check;
    static char[][] c;
    static String str;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        str = br.readLine();
        c = new char[n][n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                c[i][j] = str.charAt(cnt++);
            }
        }

        arr = new int[21];
        check = new boolean[21];
        int[] result = new int[n];
        for(int i=0; i<21; i++) {
            arr[i] = i-10;
        }

        permutation(0, n, result);
    }

    public static void permutation(int index, int n, int[] result) {
        if(flag) return;
        if(index == n) {
            for(int i=0; i<n; i++) {
                System.out.print(result[i]+" ");
            }
            flag = true;
            return;
        }
        for(int i=0; i<21; i++) {
            if(check[i]) continue;
            boolean flag = true;
            result[index] = arr[i];

            for(int j=0; j<=index; j++) {
                int sum = 0;
                for(int k=j; k<=index; k++) {
                    sum += result[k];
                }
                if((c[j][index] == '+') && (sum <= 0)) flag = false;
                if((c[j][index] == '-') && (sum >= 0)) flag = false;
                if((c[j][index] == '0') && (sum != 0)) flag = false;
            }
            if(!flag) continue;

            // check[i] = true;
            permutation(index+1, n, result);
            // check[i] = false;
        }
    }
}