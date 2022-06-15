import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();

        int MAX = 10000000;
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
        
        int cnt = 0;
        for(int i=0; i<check.length; i++) {
            if(!check[i]) cnt++;
        }

        int[] primes = new int[cnt];
        int tmp = 0;
        for(int i=0; i<check.length; i++) {
            if(!check[i]) primes[tmp++] = i;
        }

        for(int i=0; i<primes.length; i++) {
            while(n % primes[i] == 0) {
                System.out.println(primes[i]);
                n /= primes[i];
            }
            if(n == 1) break;
        }
    }
}