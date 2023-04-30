import java.util.*;
class Solution {
    static boolean[] selected;
    static int rowCnt;
    static List<List<Integer>> isUsed = new ArrayList<>();
    static int answer = 0;
    public int solution(String[][] relation) {
        
        rowCnt = relation.length;
        int colCnt = relation[0].length;
        System.out.println(rowCnt);
        System.out.println(colCnt);
        System.out.println("-----------------------");
        
        for(int r=1;r<=colCnt;r++) {
            // 4Cr 뽑기
            selected = new boolean[colCnt];
            comb(0,0,colCnt, r, relation);
        }
        return answer;
    }
    
    public void comb(int cnt, int start, int n, int r, String[][] relation) {
        if(cnt==r) {
            Set<List> set = new HashSet<>();
            
            List<Integer> idxList = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if(selected[j]) {
                    //System.out.print(j + " ");
                    idxList.add(j);
                }
            }
            
            for(int i=0;i<rowCnt;i++) {
                List<String> list = new ArrayList<>();
                for(int col : idxList) {
                    list.add(relation[i][col]);
                }
                set.add(list);
            }
            if(set.size() == rowCnt) {
                // idxList안에 isUsed안의 list 값이 들어있는지, 들어있으면 true, 없으면 false
                if(!isAlreadyUsed(idxList)) {
                    System.out.println("사용되지 않은 조합입니다!!!");
                    answer++;
                    isUsed.add(idxList);
                    System.out.println(idxList);
                    System.out.println(set);
                    System.out.println("-----------------------");
                }
                // System.out.println("사용된 컬럼 리스트start");
                // System.out.println(isUsed);
                // System.out.println("사용된 컬럼 리스트end");
            }
            return;
        }
        
        for(int i=start;i<n;i++) {
            if(selected[i]) {
                continue;
            }
            selected[i] = true;
            comb(cnt+1, i+1, n, r, relation);
            selected[i] = false;
        }
        
    }
    public boolean isAlreadyUsed(List<Integer> idxList) {
        for(List list : isUsed) {
            int cnt = 0;
            System.out.println("리스트입니다: " + list.get(0));
            
            for(int i=0;i<list.size();i++) {
                for(int idx : idxList) {
                    System.out.println("idx입니다: " + idx);
                    if((Integer) list.get(i) == idx) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt == list.size()) {
                return true;
            }
        }
        return false;
    }
}