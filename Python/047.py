# The first two consecutive numbers to have two distinct prime factors are:
#
# 14 = 2 x 7
# 15 = 3 x 5.
#
# The first three consecutive numbers to have three distinct prime factors are:
#
# 644 = 2^2 x 7 x 23
# 645 = 3 x 5 x 43
# 646 = 2 x 17 x 19.
#
# Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?

import math


def prime_factor_count(n):
    """Modify the prime sieve to count the number of prime factors (with repetition)."""

    prime_factors = [0] * n

    for i in range(2, int(math.sqrt(n)) + 1):
        if not prime_factors[i]:
            for j in range(2 * i, n, i):
                prime_factors[j] += 1

    return prime_factors


if __name__ == "__main__":
    prime_factors = prime_factor_count(10**6)
    # for idx, count in enumerate(prime_factors):
    #     print(idx, count)
    # print(prime_factors[645])
    for n in range(len(prime_factors) - 3):
        if (
            prime_factors[n]
            == prime_factors[n + 1]
            == prime_factors[n + 2]
            == prime_factors[n + 3]
            == 4
        ):
            print(n)
            break
