import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'L') {
				cnt++;
				i++;
			}
		}
		if(cnt >= 2) {
			System.out.println(n-(cnt-1));
		} else {
			System.out.println(n);
		}
	}

}