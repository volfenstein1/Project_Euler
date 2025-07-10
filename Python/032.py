# We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
#
# The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
#
# Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
#
# HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

# For all pandigital numbers n, and for all factors d of n, see if set(str(d) + str(n//d)) = {str(x) for x in range(1,10)}


import math
from itertools import permutations, combinations


def get_divisor_pairs(n):
    divisors = []
    i = 1
    while i <= math.sqrt(n):
        if n % i == 0:
            divisors.append((i, n // i))
        i = i + 1
    return divisors


def check_pandigital(n):
    for a, b in get_divisor_pairs(n):
        digits_seen = sorted(str(n) + str(a) + str(b))
        if digits_seen == [str(x) for x in range(1, 10)]:
            return True
    return False


if __name__ == "__main__":
    res = 0
    for l in range(1, 5):
        for product_digits in combinations([str(x) for x in range(1, 10)], l):
            for possible_product in permutations(product_digits):
                n = int("".join(possible_product))
                if check_pandigital(n):
                    res += n
    print(res)
