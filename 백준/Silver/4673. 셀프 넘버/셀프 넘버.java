public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        for(int i=0; i<101; i++) {
            check[i] = false;
        }

        int[] div = {10000, 1000, 100, 10, 1};
        for(int i=1; i<=10000; i++) {
            int tmp = i;
            int sum = 0;
            while(true) {
                if(check[sum]) break;  
                sum += tmp;
                for(int j=0; j<div.length; j++) {
                    sum += tmp/div[j];
                    tmp %= div[j];
                }
                if(sum > 10000) break;
                check[sum] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10001; i++) {
            if(!check[i]) sb.append(i+"\n");
        }
        System.out.println(sb);
    }    
}