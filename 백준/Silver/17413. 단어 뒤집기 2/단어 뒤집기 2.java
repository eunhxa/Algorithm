import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for(int i=0; i<str.length()-1; i++) {
            switch(str.charAt(i)) {
            case '<':
                while(str.charAt(i) != '>') {
                    queue.offer(str.charAt(i));
                    i++;
                }
                queue.offer(str.charAt(i));
                while(queue.size() > 0) {
                    sb.append(queue.poll());
                }
                break;
            case ' ':
                sb.append(' ');
                break;
            default:
                while(i != str.length() && str.charAt(i) != ' ' && str.charAt(i) != '<') {
                    stack.add(str.charAt(i));
                    i++;
                }
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                i--;
                break;
            }
        }
        System.out.println(sb);

    }
}