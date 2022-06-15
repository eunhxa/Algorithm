import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 1000000;
        int cnt = 0;
        boolean[] check = new boolean[MAX+1];
        for(int i=0; i<check.length; i++) {
            check[i] = false;
        }
        check[0] = true;
        check[1] = true;

        for(int i=2; i*i<=MAX; i++) {
            for(int j=i*i; j<=MAX; j+=i) {
                check[j] = true;
            }
        }

        for(int i=0; i<check.length; i++) {
            if(!check[i]) cnt++;
        }
        
        int[] primes = new int[cnt];
        int tmp = 0;
        for(int i=0; i<check.length; i++) {
            if(!check[i]) primes[tmp++] = i; 
        }

        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            cnt = 0;
            int n = Integer.parseInt(br.readLine());
            
            for(int i=0; i<primes.length; i++) {
                if(n <= primes[i]) break;
                if(!check[n-primes[i]]) {
                    cnt++;
                    if(primes[i] == n-primes[i]) cnt++;
                }
            }
            System.out.println(cnt/2);
        }
    }
}