from collections import defaultdict
import operator
def solution(genres, plays):
    answer = []
    
    genre_cnt = defaultdict(int)
    genre_list = defaultdict(list)
    
    
    for i in range(len(genres)):
        genre_cnt[genres[i]] += plays[i]
        genre_list[genres[i]].append([i, plays[i]])
    
    # print(genre_cnt)
    sorted_genre_cnt = sorted(genre_cnt.items(), key=operator.itemgetter(1), reverse=True)
    # print(sorted_genre_cnt)
    for genre, _ in sorted_genre_cnt:
        genre_list[genre].sort(key = lambda x : x[1], reverse=True)
        
        for i in range(len(genre_list[genre])):
            if i == 2:
                break
            answer.append(genre_list[genre][i][0])
            
        # print(genre_list[genre])
    
    return answer