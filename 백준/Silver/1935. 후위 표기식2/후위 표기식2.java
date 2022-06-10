import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                stack.push(arr[str.charAt(i)-'A']);
            } else {
                double j = stack.pop();
                double k = stack.pop();
                switch(str.charAt(i)) {
                    case '+':
                        stack.push(k + j);
                        break;
                    case '-':
                        stack.push(k - j);
                        break;
                    case '*':
                        stack.push(k * j);
                        break;
                    case '/':
                        stack.push(k / j);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}