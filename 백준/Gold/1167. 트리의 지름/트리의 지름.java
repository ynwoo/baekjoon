import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node implements Comparable<Node> {
	int vertex;
	Map<Node, Integer> childs = new TreeMap<Node, Integer>();

	public Node(int vNum) {
		vertex = vNum;
	}

	@Override
	public int compareTo(Node o) {
		if (this.vertex < o.vertex) {
			return -1;
		} else if (this.vertex == o.vertex) {
			return 0;
		} else {
			return 1;
		}
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int V;
	static Node[] tree;
	static Node furthestNode, tempNode1, tempNode2;
	static boolean[] visited;
	static int temp, answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		V = Integer.parseInt(br.readLine());
		tree = new Node[V + 1];
		for (int i = 1; i <= V; i++) {
			tree[i] = new Node(i);
		}

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vNum = Integer.parseInt(st.nextToken());

			while (true) {
				int nextV = Integer.parseInt(st.nextToken());
				if (nextV == -1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());

				tree[vNum].childs.put(tree[nextV], weight);
			}
		}

		// 구현(시간초과)
//		for (int i = 1; i <= V; i++) {
//			if (isLeafNode(tree[i])) {
//				temp = 0;
//				visited = new boolean[V + 1];
//				dfs(i);
//				// dfs 순회
//			}
//		}
		visited = new boolean[V + 1];
		temp = 0;
		dfs(1);
		
		visited = new boolean[V + 1];
		answer = Integer.MIN_VALUE;
		temp = 0;
		dfs(furthestNode.vertex);

		System.out.println(answer);
		br.close();
	}

	private static void dfs(int i) {
		// 방문
		visited[i] = true;
		for (Node childNode : tree[i].childs.keySet()) {
			int nextVertex = childNode.vertex;
			if (!visited[nextVertex]) {
				temp += tree[i].childs.get(childNode);
//				if (isLeafNode(tree[nextVertex])) {
//					answer = Math.max(answer, temp);
//				}
				if (answer < temp) {
					answer = Math.max(answer, temp);
					furthestNode = tree[nextVertex];
				}
				dfs(nextVertex);
				temp -= tree[i].childs.get(childNode);
			}
		}

	}

	private static boolean isLeafNode(Node node) {
		if (node.childs.size() == 1) {
			return true;
		}
		return false;
	}

}