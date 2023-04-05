import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        int si = 0, sj = 0, ei = 0, ej = 0;
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    si = i;
                    sj = j;
                } else if (map[i][j] == 'D') {
                    ei = i;
                    ej = j;
                }
            }
        }

        bfs(r, c, map, si, sj, ei, ej);
        System.out.println("KAKTUS");

    }

    private static void bfs(int r, int c, char[][] map, int si, int sj, int ei, int ej) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[r][c];
        visited[si][sj] = true;
        queue.offer(new Point(si, sj));
        while (!queue.isEmpty()) {
            // 이동 하기 전에 물 처리
            boolean[][] madeBy = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == '*' && !madeBy[i][j]) {
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];
                            if (0 > ni || r <= ni || 0 > nj || c <= nj) {
                                continue;
                            }
                            if (map[ni][nj] == 'D' || map[ni][nj] == 'S' || map[ni][nj] == 'X') {
                                continue;
                            }
                            if(map[ni][nj] != '*') {
                                madeBy[ni][nj] = true;
                                map[ni][nj] = '*';
                            }

                        }
                    }
                }
            }
            //printMap(map);
            int size = queue.size();
            while (--size >= 0) {
                Point cur = queue.poll();

                if(map[cur.x][cur.y] == 'D') {
                    System.out.println(answer);
                    System.exit(0);
                }
                for (int d = 0; d < 4; d++) {
                    int ni = cur.x + di[d];
                    int nj = cur.y + dj[d];
                    if (0 > ni || r <= ni || 0 > nj || c <= nj) {
                        continue;
                    }
                    if (map[ni][nj] == 'X' || map[ni][nj] == '*') {
                        continue;
                    }
                    if(!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        queue.offer(new Point(ni,nj));
                    }
                }
            }
            answer++;
        }
    }

    private static void printMap(char[][] map) {
        for (int i=0;i<map.length;i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

}