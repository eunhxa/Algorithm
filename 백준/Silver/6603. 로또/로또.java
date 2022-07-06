import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] arr;
	static int[] solution;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			int n = scanner.nextInt();
			if(n == 0) {
				System.out.print(sb);
				return;
			}
			
			arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = scanner.nextInt();
			}
			
			visited = new boolean[n];
			solution = new int[6];
			dfs(0, 6, 0);
			sb.append("\n");
		}
		
	}
	
	public static void dfs(int k, int limit, int start) {
		if(k == limit) {
			for(int i=0; i<solution.length; i++) {
				sb.append(solution[i]).append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i=start; i<arr.length; i++) {
				if(!visited[i]) {
					solution[k] = arr[i];
					visited[i] = true;
					dfs(k+1, limit, i);
					visited[i] = false;
				}
			}
		}
	}
	
}