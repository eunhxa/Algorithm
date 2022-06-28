import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken()); //올라가는 높이
        double b = Double.parseDouble(st.nextToken()); //미끄러지는 높이
        double v = Double.parseDouble(st.nextToken()); //나무 높이

        System.out.println((int)(Math.ceil((v-a)/(a-b))+1));
    }
}