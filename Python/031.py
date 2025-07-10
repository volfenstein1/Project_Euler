# In the United Kingdom the currency is made up of pound (£) and pence (p). There are eight coins in general circulation:
#
# 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p), and £2 (200p).
#
# It is possible to make £2 in the following way:
#
# 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
#
# How many different ways can £2 be made using any number of coins?

coins = [1, 2, 5, 10, 20, 50, 100, 200]
total_ways = [0] * 201
total_ways[0] = 1

for coin in coins:
    for x in range(len(total_ways) - coin):
        total_ways[x + coin] += total_ways[x]

if __name__ == "__main__":
    print(total_ways[200])
