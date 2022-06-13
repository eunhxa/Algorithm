import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = ""; 
        try {
            while((str = br.readLine()) != null) {
                int[] arr = new int[4];
                for(int i=0; i<4; i++) {
                    arr[i] = 0;
                }
                for(int i=0; i<str.length(); i++) {
                    char c = str.charAt(i);
                    if(c >= 'a' && c <= 'z') {
                        arr[0]++;
                    } else if(c >= 'A' && c <= 'Z') {
                        arr[1]++;
                    } else if(c >= '0' && c <= '9') {
                        arr[2]++;
                    } else {
                        arr[3]++;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for(int i=0; i<4; i++) {
                    sb.append(arr[i]+" ");
                }
                System.out.println(sb);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}