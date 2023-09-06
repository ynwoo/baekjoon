def solution(record):
    answer = []
    hash_map = {}
    
    for r in record:
        l = r.split()
        if l[0] == "Enter":
            hash_map[l[1]] = l[2]
        elif l[0] == "Change":
            hash_map[l[1]] = l[2]

    for r in record:
        l = r.split()
        if l[0] == "Enter":
            answer.append(hash_map[l[1]]+"님이 들어왔습니다.")
        elif l[0] == "Leave":
            answer.append(hash_map[l[1]]+"님이 나갔습니다.")

    return answer