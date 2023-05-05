import java.util.*;
class Solution {
    static int m, n;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        m = key.length;
        n = lock.length;
        int newlength = n+(m-1)*2;
        int[][] newLock = new int[newlength][newlength];
        
        for(int i=(m-1);i<(m-1)+n;i++) {
            for(int j=(m-1);j<(m-1)+n;j++) {
                newLock[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        int zeroCnt = getCnt(newLock, n, m);
        System.out.println(zeroCnt);
        if(zeroCnt == 0) {
            return true;
        }
        
        // key 4방향 회전하는 for문 추가 필요
        for(int k = 0;k<4;k++) {
            key = rotate90(key);
            for(int i=0;i < newlength - (m-1);i++) {
                for(int j=0;j < newlength - (m-1);j++) {
                    if(tryUnlock(key, newLock, i, j)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public int[][] rotate90(int[][] key) {
        int[][] copyKey = new int[key.length][key.length];
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                copyKey[j][key.length-1-i] = key[i][j];
            }
        }
        return copyKey;
    }
    public int getCnt(int[][] newLock, int n, int m) {
        int cnt = 0;
        for(int i=(m-1);i<(m-1)+n;i++) {
            for(int j=(m-1);j<(m-1)+n;j++) {
                if(newLock[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean tryUnlock(int[][] key, int[][] newLock, int startI, int startJ) {
        int[][] cloneLock = new int[newLock.length][newLock.length];
        for(int i=0;i<newLock.length;i++) {
            cloneLock[i] = newLock[i].clone();
        }

        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                if(cloneLock[i+startI][j+startJ] == 1 && key[i][j] == 1) {
                    return false;
                }
                cloneLock[i+startI][j+startJ] |= key[i][j];
            }
        }
        int zeroCnt = getCnt(cloneLock, n, m);
        
        // for(int i=0;i<newLock.length;i++) {
        //     for(int j=0;j<newLock.length;j++) {
        //         System.out.print(cloneLock[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("--------------------");
        // System.out.println(zeroCnt);
        
        if(zeroCnt == 0) {
            return true;
        }
        return false;
    }
}