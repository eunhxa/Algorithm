import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] t = new int[n+1];
		
		t[0] = 0;
		t[1] = 1;
		if(n >= 2) {
			t[2] = 3;
		}
		
		for(int i=3; i<=n; i++) {
			t[i] = (t[i-1] + t[i-2]*2)%10007;
		}
		
		System.out.println(t[n]);
	}

}