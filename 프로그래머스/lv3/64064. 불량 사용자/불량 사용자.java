import java.util.*;
class Solution {
    static String[] candidates;
    static List<String> cases = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        // user_id에서 banned_id개수만큼 순열
        candidates = new String[banned_id.length];
        permutation(0,0, user_id, banned_id);
        
        for(String c : cases) {
            System.out.println(c);    
        }
        
        return cases.size();
    }
    
    public void permutation(int cnt, int flag, String[] user_id, String[] banned_id) {
        if(cnt == banned_id.length) {
            //System.out.println(Arrays.toString(candidates));
            for(int i=0;i<candidates.length;i++) {
                if(candidates[i].length() != banned_id[i].length()) {
                    return;
                }
                for(int j=0;j<candidates[i].length();j++) {
                    if(candidates[i].charAt(j) == banned_id[i].charAt(j) || banned_id[i].charAt(j) == '*') {
                        continue;
                    }
                    return;
                }
            }
            //System.out.println(Arrays.toString(candidates));
            String[] temp = candidates.clone(); 
            Arrays.sort(temp);
            if(!cases.contains(Arrays.toString(temp))) {
                cases.add(Arrays.toString(temp));
            }
            return;
        }
        
        for(int i=0;i<user_id.length;i++) {
            if((flag & (1 << i)) != 0) {
                continue;
            }
            candidates[cnt] = user_id[i];
            permutation(cnt+1, flag | (1<<i), user_id, banned_id);
        }
    }
}