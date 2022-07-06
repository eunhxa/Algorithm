import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static boolean[] check;
    static char[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new char[c];
        check = new boolean[c];
        result = new char[c];
        for(int i=0; i<c; i++) {
            arr[i] = stk.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        go(0, l, c);
        System.out.println(sb);
    }

    public static void go(int index, int l, int c) {
        if(index == l) {
            StringBuilder tmp = new StringBuilder();
            for(int i=0; i<l; i++) {
                tmp.append(result[i]);
            }
            String str = tmp.toString();
            str = str.replace("a", "")
            .replace("i", "")
            .replace("u", "")
            .replace("e", "")
            .replace("o", "");
            if((str.length() < l) && str.length() >= 2) {
                for(int i=0; i<l; i++) {
                    sb.append(result[i]);
                }
                sb.append("\n");
            } 
        } else {
            for(int i=0; i<c; i++) {
                if(check[i]) continue;
                if(index >= 1 && (result[index-1] > arr[i])) continue;
                check[i] = true;
                result[index] = arr[i];
                go(index+1, l, c);
                check[i] = false;
            }
        }
    }
}