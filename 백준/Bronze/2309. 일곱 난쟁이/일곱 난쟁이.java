import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        boolean flag = false;
        for(int i=0; i<9; i++) {
            for(int j=i; j<9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; i++) {
            if(arr[i] != 0) {
                sb.append(arr[i]+"\n");
            }
        }
        System.out.println(sb);
    }
}