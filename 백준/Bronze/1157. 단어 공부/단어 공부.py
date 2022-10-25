from collections import Counter
import sys
input = sys.stdin.readline


s = input().strip().upper()

most_common = Counter(s).most_common()
if len(most_common) != 1:
  if most_common[0][1] == most_common[1][1]:
    print('?')
  else:
    print(most_common[0][0])
else:
  print(most_common[0][0])
