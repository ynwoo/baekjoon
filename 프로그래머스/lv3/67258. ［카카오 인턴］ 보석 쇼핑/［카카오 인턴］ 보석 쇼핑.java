import java.util.*;


class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> jMap = new HashMap<>();

        int n = gems.length; // 보석 전체 개수
        int numOfJewelryTypes = set.size(); // 보석 종류 개수
        int left = 0;
        int right = 0;
        
        while(true) {
            if(jMap.size() == numOfJewelryTypes) {
                jMap.put(gems[left], jMap.get(gems[left])-1);
                if (jMap.get(gems[left]) == 0) {
                    jMap.remove(gems[left]);
                }
                left++;
            } else {
                if(right == n) {
                    break;
                }
                jMap.put(gems[right], jMap.getOrDefault(gems[right], 0) + 1);
                right++;
            }
                
            if (jMap.size() == numOfJewelryTypes && minLength > right - left) {
                minLength = right - left;
                answer[0] = left + 1;
                answer[1] = right;
            }
        }
        
        return answer;
    }
}