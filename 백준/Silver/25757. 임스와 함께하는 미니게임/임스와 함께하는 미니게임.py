from sys import stdin
input = stdin.readline
games = {'Y' : 2, 'F' : 3, 'O' : 4}
n, game = input().rstrip().split()
people = set()
for _ in range(int(n)):
  people.add(input().rstrip())

print(len(people) // (games[game] - 1))