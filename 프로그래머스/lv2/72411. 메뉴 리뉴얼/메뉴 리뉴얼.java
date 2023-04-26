import java.util.*;

class Solution {
    static Map<String, Integer> courseMap;
    static char[] c, menus;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        for(int i =0;i<course.length;i++) {
            courseMap = new HashMap<>();
            c = new char[course[i]];
            
            for(String order : orders) {
                // 메뉴개수 C course[i] 조합 뽑아서 courseMap에 추가
                menus = order.toCharArray();
                Arrays.sort(menus);
                comb(0, 0, menus.length, course[i]);  
            }
            
            if(courseMap.values().size() > 0) {
                int maxValue = Collections.max(courseMap.values());
                if(maxValue >= 2) {
                    for(String key : courseMap.keySet()){
                        if(courseMap.get(key) == maxValue) {
                            list.add(key);
                        }
                    }    
                }
            }
        }
        Collections.sort(list);
        // System.out.println(list);
        answer = list.toArray(new String[0]);

        return answer;
    }
    
    public void comb(int cnt, int start, int n, int r) {
        if (cnt == r) {
            courseMap.put(String.valueOf(c), courseMap.getOrDefault(String.valueOf(c), 0) + 1);
			return;
		}
		for (int i = start; i < n; i++) {
			c[cnt] = menus[i];
			comb(cnt + 1, i + 1, n, r);
		}
    }
}