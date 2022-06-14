import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] check = new boolean[n+1];
        check[0] = true;
        check[1] = true;
        for(int i=2; i<=n; i++) {
            check[i] = false;
        }

        for(int i=2; i*i<=n; i++) {
            for(int j=i*i; j<=n; j+=i) {
                check[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=m; i<=n; i++) {
            if(!check[i]) {
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }
}