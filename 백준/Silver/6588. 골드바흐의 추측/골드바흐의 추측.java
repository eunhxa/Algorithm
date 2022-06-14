import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int MAX = 1000000;
        int[] arr = new int[MAX+1];
        boolean[] check = new boolean[MAX+1];

        for(int i=0; i<=MAX; i++) {
            arr[i] = i;
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
        for(int i=0; i<=MAX; i++) {
            if(!check[i]) cnt++;
        }
        int[] resultArr = new int[cnt];
        int num = 0;
        for(int i=0; i<=MAX; i++) {
            if(!check[i]) {
                resultArr[num] = i;
                num++;
            }
        }
        

        while((n=sc.nextInt()) != 0) {
            boolean flag = false;
            for(int i=0; i<resultArr.length; i++) {
                int j = n - resultArr[i];
                if(j>0 && !check[j]) {
                    flag = true;
                    System.out.println(n+" = "+resultArr[i]+" + "+j);
                    break;
                }
            }
            if(!flag) System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}