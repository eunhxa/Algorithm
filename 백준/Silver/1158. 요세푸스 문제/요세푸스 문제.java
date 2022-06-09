import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        for(int i=1; queue.size() > 0; i++) {
            if(i % k == 0) {
                sb.append(queue.poll());
                if(queue.size() == 0) {
                    sb.append(">");
                } else {
                    sb.append(", ");
                }
            } else {
                queue.add(queue.poll());
            }
        }

        System.out.println(sb);

    }
}