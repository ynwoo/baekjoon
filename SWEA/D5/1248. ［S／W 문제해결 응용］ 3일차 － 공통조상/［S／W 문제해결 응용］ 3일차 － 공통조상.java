import java.util.*;


class Solution
{
    static int answer = 0, count = 0;
    static class Node {
        int parent, left, right;
        boolean visited;
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node[] tree = new Node[V+1];
            for(int i = 0; i < V+1; i++) {
                tree[i] = new Node();
            }

            for(int i = 0; i < E; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();

                tree[child].parent = parent;
                if (tree[parent].left == 0) {
                    tree[parent].left = child;
                } else {
                    tree[parent].right = child;
                }
            }
            answer = 0; // 공통 조상의 정점 번호
            count = 0; // 서브 트리의 크기
            // a의 조상 방문
            visitAncestors(tree, a);
            // b의 조상 방문
            visitAncestors(tree, b);
            // 공통 조상의 서브 트리 크기 구하기
            preOrder(tree, answer);

            System.out.println("#" + test_case + " " + answer + " " + count);
        }
        sc.close();
    }
    static void visitAncestors(Node[] tree, int num) {
        while ( num != 0) {
            int p = tree[num].parent;
            if (tree[p].visited) {
                answer = p;
                return;
            }
            tree[num].visited = true;
            num = p;
        }
    }
    static void preOrder(Node[] tree, int num) {
        if (num != 0) {
            int l = tree[num].left;
            int r = tree[num].right;
            count += 1;
            preOrder(tree, l);
            preOrder(tree, r);
        }
    }
}