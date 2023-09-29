def solution(files):
    answer = []
    new_files = []
    for file in files:
        new_file = []
        in_number = False
        n_idx = 0
        t_idx = 0
        done = False
        for i in range(len(file)):
            if '0' <= file[i] and file[i] <='9' and not in_number and not done:
                in_number = True
                n_idx = i
            elif '0' <= file[i] and file[i] <='9' and in_number and not done:
                t_idx = i
            elif in_number:
                done = True
        
        if t_idx == 0:
            head = file[:n_idx]
            number = file[n_idx:n_idx+1]
            tail = file[n_idx+1:]
        else:
            head = file[:n_idx]
            number = file[n_idx:t_idx+1]
            tail = file[t_idx+1:]
        new_file.append(head)
        new_file.append(number)
        new_file.append(tail)
        new_files.append(new_file)
        new_file.append(int(number))
    
    sorted_new_files = sorted(new_files, key = lambda x : (x[0].lower(), x[3]))
    for new_file in sorted_new_files:
        answer.append(new_file[0]+new_file[1]+new_file[2])
    # print(sorted_new_files)
    return answer