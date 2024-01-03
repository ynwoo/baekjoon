from sys import stdin
input = stdin.readline

n = int(input())
print("CY") if n % 2 == 0 else print("SK")