import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int answer = 0;

        for(int i = 0; i < t.length(); i++) {
            String subStr = t.substring(i);
            answer = Math.max(answer, getLength(subStr));
        }

        System.out.println(answer);
    }

    // 해당 문자열 내에 존재하는 부분 문자열 중 접두사와 접미사가 같은 문자열의 최대 길이 구하기.
    static int getLength(String str) {
        int n = str.length(), max = 0;
        int pi[] = new int[n];

        for(int i = 1, j = 0; i < n; i++) { // i : 우측(접미사) 비교 문자열 인덱스
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }

            if(str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            } else{
                pi[i] = 0;

            }

        }
        // System.out.println(Arrays.toString(pi));
        return max;
    }
}