import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] aCnt = new int[N+1];
        int[] bCnt = new int[N+1];

        aCnt[0] = 1;
        bCnt[0] = 0;
        for (int i=1;i<=N;i++) {
            aCnt[i] = bCnt[i-1];
            bCnt[i] = bCnt[i-1] + aCnt[i-1];
        }
        System.out.println(aCnt[N] + " " + bCnt[N]);
    }


}