import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static int N;
	static Map<String, Map> root = new TreeMap<String, Map>((s1, s2) -> s1.compareTo(s2));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			Map<String, Map> current = root;
			for (int j = 0; j < k; j++) {
				String s = st.nextToken();
				if (current.get(s) == null) {
					Map<String, Map> newV = new TreeMap<String, Map>((s1, s2) -> s1.compareTo(s2));
					current.put(s, newV);
					current = newV;
				} else {
					current = current.get(s);
				}
			}
		}

		// dfs
		Map<String, Map> current = root;
		dfs(current, 0);

		System.out.println(sb);
	}

	private static void dfs(Map<String, Map> current, int level) {

		for (Map.Entry<String, Map> entry : current.entrySet()) {
			for (int i = 0; i < level; i++) {
				sb.append("--");
			}
			sb.append(entry.getKey()).append("\n");
			dfs(entry.getValue(), level + 1);
		}
	}

}