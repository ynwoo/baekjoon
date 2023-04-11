import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] answer;
    static int[][] num;
    static int n, m, cnt;
    static boolean[][] visited;
    static HashMap<Integer, Integer> hm = new HashMap<>();// 몇 번 그룹이 몇개를 가지고 있는지

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        answer = new int[n][m];
        num = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0' && !visited[i][j]) {
                    cnt++;
                    bfs(map, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    answer[i][j]++;
                    HashSet<Integer> hs = new HashSet<>();
                    // 4방 탐색, 묶음들 정보가 다르면 answer에 count값 더해줌
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];

                        if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                            continue;
                        }
                        if (map[ni][nj] == '1') {
                            continue;
                        }
                        hs.add(num[ni][nj]);
                    }

                    for(Integer n : hs) {
                        answer[i][j] += hm.get(n);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    private static void bfs(char[][] map, int i, int j) {
        int tCnt = 0;
        Queue<Point> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            tCnt++;
            num[cur.x][cur.y] = cnt;
            for (int d = 0; d < 4; d++) {
                int ni = cur.x + di[d];
                int nj = cur.y + dj[d];

                if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                    continue;
                }
                if (map[ni][nj] == '1') {
                    continue;
                }

                if (!visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.offer(new Point(ni, nj));
                }
            }
        }
        hm.put(cnt, tCnt);
    }
}