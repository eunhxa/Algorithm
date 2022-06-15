import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<tc; t++) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(str[i+1]);
            }
            long sum = 0;

            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    int a = arr[i];
                    int b = arr[j];

                    while(true) {
                        int r = a%b;
                        if(r == 0) break;
                        a = b;
                        b = r;
                    }
                    sum += b;
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
}