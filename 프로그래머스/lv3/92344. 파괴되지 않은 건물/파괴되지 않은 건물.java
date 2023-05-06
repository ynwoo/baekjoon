import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        // board[1000][1000]
        // skill.length <= 250,000
        // 250,000 * 1,000 * 1,000 => 2천5백억(시간초과)
        int answer = 0;
        int skillLength = skill.length;
        int[][] temp = new int[board.length + 1][board[0].length + 1];
        
        for(int l=0;l<skillLength;l++) {
            int type = skill[l][0];
            int si = skill[l][1];
            int sj = skill[l][2];
            int ei = skill[l][3] + 1;
            int ej = skill[l][4] + 1;
            int amount = skill[l][5];
            
            if(type == 1) {
                temp[si][sj] -= amount;
                temp[ei][ej] -= amount;
                temp[si][ej] += amount;
                temp[ei][sj] += amount;
            } else {
                temp[si][sj] += amount;
                temp[ei][ej] += amount;
                temp[si][ej] -= amount;
                temp[ei][sj] -= amount;
            }
        }
        
        for(int j=0;j<temp[0].length;j++) {
            for(int i=1;i<temp.length;i++) {
                temp[i][j] += temp[i-1][j];
            }
        }
        for(int i=0;i<temp.length;i++) {
            for(int j=1;j<temp[0].length;j++) {
                temp[i][j] += temp[i][j-1];
            }
            System.out.println();
        }
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                board[i][j] += temp[i][j];
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}