from sys import stdin
input = stdin.readline

h, w, n, m = map(int, input().split())
print((1 + (h - 1) // (1 + n)) * (1 + (w - 1) // (1 + m)))