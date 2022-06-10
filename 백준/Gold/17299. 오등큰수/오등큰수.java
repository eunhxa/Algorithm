import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] res = new int[n];
        int[] freq = new int[1000001];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<=n; i++) {
            freq[i] = 0;
        }

        String[] sarr = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
            freq[arr[i]]++;
        }

        for(int i=0; i<n; i++) {
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            if(!stack.empty()) {
                while(!stack.empty()) {
                    if(freq[arr[i]] > freq[arr[stack.peek()]]) {
                        res[stack.pop()] = arr[i];
                    } else {
                        break;
                    }
                }
            }
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            sb.append(res[i]+" ");
        }
        System.out.println(sb);
    }
    
}