import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		splited = new String[n];
		for(int i=0; i<n; i++) {
			splited[i] = scanner.next();
		}
		arr = new int[n+1];
		visited = new boolean[10];
		
		dfs(0,n+1);
		
		if(max < Math.pow(10, n)) System.out.print("0");
		System.out.println(max);
		if(min < Math.pow(10, n)) System.out.print("0");
		System.out.println(min);
	}
	
	static int[] arr;
	static boolean[] visited;
	static String[] splited;
	static long min = Long.MAX_VALUE;
	static long max = 0;
	
	
	public static void dfs(int k, int limit) {
		if(k == limit) {
			boolean flag;
			for(int i=0; i<=arr.length-2; i++) {
				int a = arr[i];
				int b = arr[i+1];
				char s = splited[i].charAt(0);
				
				flag = check(a,b,s);
				if(flag == false) return;
			}
			long temp = 0;
			for(int i=0; i<arr.length; i++) {
				temp*=10;
				temp += arr[i];
			}
			if(temp < min) min = temp;
			if(temp > max) max = temp;
		}
		else {
			for(int i=0; i<=9; i++) {
				if(!visited[i]) {
					arr[k] = i;
					visited[i] = true;
					dfs(k+1, limit);
					visited[i] = false;
				}
			}
		}
	}
	
	public static boolean check (int a, int b, char symbol) {
		if(symbol == '<') {
			return a<b;
		}
		else { // '>'
			return a>b;
		}
	}
}