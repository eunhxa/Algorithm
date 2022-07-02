import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.print.attribute.PrintRequestAttribute;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char arr[][] = new char[n][n];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                char tmp = arr[i][j];
                char before;
                int cnt = 1;

                if(i+1 < n) {
                    arr[i][j] = arr[i+1][j];
                    arr[i+1][j] = tmp;

                    for(int k=0; k<n; k++) {
                        before = ' ';
                        for(int l=0; l<n; l++) {
                            if(before == arr[k][l]) {
                                cnt++;
                            }
                            else {
                                cnt = 1;
                            }
                            if(max < cnt) max = cnt;
                            before = arr[k][l];
                        }
                    }

                    for(int k=0; k<n; k++) {
                        before = ' ';
                        for(int l=0; l<n; l++) {
                            if(before == arr[l][k]) {
                                cnt++;
                            }
                            else {
                                cnt = 1;
                            }
                            if(max < cnt) max = cnt;
                            before = arr[l][k];
                        }
                    }

                    arr[i+1][j] = arr[i][j];
                    arr[i][j] = tmp;
                }

                if(j+1 < n) {
                    arr[i][j] = arr[i][j+1];
                    arr[i][j+1] = tmp;
                    for(int k=0; k<n; k++) {
                        before = ' ';
                        for(int l=0; l<n; l++) {
                            if(before == arr[k][l]) {
                                cnt++;
                            }
                            else {
                                cnt = 1;
                            }
                            if(max < cnt) max = cnt;
                            before = arr[k][l];
                        }
                    }

                    for(int k=0; k<n; k++) {
                        before = ' ';
                        for(int l=0; l<n; l++) {
                            if(before == arr[l][k]) {
                                cnt++;
                            }
                            else {
                                cnt = 1;
                            }
                            if(max < cnt) max = cnt;
                            before = arr[l][k];
                        }
                    }

                    arr[i][j+1] = arr[i][j];
                    arr[i][j] = tmp;
                }
            }
        }
        System.out.println(max);
    }
}