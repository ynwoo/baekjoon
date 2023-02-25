import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = null;
		String input;
		int n;
		// 입력이 없을 때 까지
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			n = Integer.parseInt(input);
			// System.out.println(n);
			root = insert(root, n);
		}

		// 후위 순회 결과 출력
		traversal(root);
	}

	private static Node insert(Node node, int n) {
		if (node == null) {
			return new Node(n);
		}

		if (n < node.key) { // 현재 노드의 키보다 작으면 왼쪽 서브트리에 추가
			node.left = insert(node.left, n);
		} else if (node.key < n) { // 현재 노드의 키보다 크면 오른쪽 서브트리에 추가
			node.right = insert(node.right, n);
		}
		return node;
	}
	
	private static void traversal(Node node) {
		if(node == null) {
			return;
		}
		traversal(node.left);
		traversal(node.right);
		System.out.println(node.key); // 후위 순회
	}
}