from sys import stdin
input = stdin.readline

h, m = map(int, input().split())
t = int(input())
m += t
print(((h + m // 60) % 24), m % 60)