from collections import defaultdict
def solution(fees, records):
    answer = []
    
    record = defaultdict(list)
    
    for s in records:
        t, number, _ = s.split()
        h, m = t.split(':')
        record[number].append(int(h) * 60 + int(m))
    
    for key, value in record.items():
        if len(value) % 2 == 1:
            record[key].append(23*60+59)
    record = dict(sorted(record.items()))
    
    for key, value in record.items():
        l = len(value)
        s = 0
        for i in range(0,l,2):
            price = value[i+1] - value[i]
            s += price
            
        if s <= fees[0]:
            answer.append(fees[1])
        else:
            s -= fees[0]
            s, mod = divmod(s, fees[2])
            if mod != 0:
                s += 1
            answer.append(fees[1] + s * fees[3])
    
        
    print(record)
    return answer