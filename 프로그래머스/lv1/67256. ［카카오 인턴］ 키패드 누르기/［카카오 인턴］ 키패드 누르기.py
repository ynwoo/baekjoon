def solution(numbers, hand):
    answer = ''
    phone = [[1,2,3], [4,5,6], [7,8,9], ['*',0,'#']]
    li, lj = 3, 0
    ri, rj = 3, 2
    
    for n in numbers:
        if n == 1:
            li, lj = 0, 0
            answer+='L'
        elif n == 4:
            li, lj = 1, 0
            answer+='L'
        elif n == 7:
            li, lj = 2, 0
            answer+='L'
            
        elif n == 3:
            ri, rj = 0, 2
            answer+='R'
        elif n == 6:
            ri, rj = 1, 2
            answer+='R'
        elif n == 9:
            ri, rj = 2, 2
            answer+='R'
        else:
            if n == 2:
                c1, c2 = 0, 1
            elif n == 5:
                c1, c2 = 1, 1
            elif n == 8:
                c1, c2 = 2, 1
            else:
                c1, c2 = 3, 1
            d1 = abs(li-c1) + abs(lj-c2)
            d2 = abs(ri-c1) + abs(rj-c2)
            if d1 > d2:
                answer+='R'
                ri, rj = c1, c2
            elif d1 < d2:
                answer+='L'
                li, lj = c1, c2
            else:
                if hand == 'left':
                    answer+='L'
                    li, lj = c1, c2
                else:
                    answer+='R'
                    ri, rj = c1, c2
                    
    return answer