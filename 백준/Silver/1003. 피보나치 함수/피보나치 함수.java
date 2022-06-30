import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] d = new int[n+1];
            d[0] = 1;
            if(n > 0) d[1] = 0;

            for(int i=2; i<=n; i++) {
                d[i] = d[i-1] + d[i-2];
            }
            sb.append(d[n]+" ");

            d[0] = 0;
            if(n > 0) d[1] = 1;

            for(int i=2; i<=n; i++) {
                d[i] = d[i-1] + d[i-2];
            }
            sb.append(d[n]+"\n");
        }
        System.out.println(sb);
    }
}