import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
            } 
            else {
                if(c == '+' || c == '-') {
                    while(!s.empty() && s.peek() != '(') {
                        sb.append(s.pop());
                    }
                    s.push(c);
                } else if (c == '/' || c == '*') {
                    while(!s.empty() && s.peek() != '+' && s.peek() != '-' && s.peek() != '(') {
                        sb.append(s.pop());
                    }
                    s.push(c);
                } else if (c == '(') {
                    s.push(c);
                } else {
                    while(s.peek() != '(') {
                        sb.append(s.pop());
                    }
                    s.pop();
                }
            }
        }
        while(!s.empty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);
    }
}