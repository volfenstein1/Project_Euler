# Consider the fraction, n/d, where n and d are positive integers. If n < d and HCF(n,d)=1, it is called a reduced proper fraction.
# If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:
#
# 1/8, 1/7,  1/6,  1/5,  1/4,  2/7,  1/3,  3/8,  2/5,  3/7,  1/2,  4/7,  3/5,  5/8,  2/3,  5/7,  3/4,  4/5,  5/6,  6/7,  7/8
#
# It can be seen that there are 21 elements in this set.
# How many elements would be contained in the set of reduced proper fractions for d <= 1,000,000?

import math

# def prime_sieve(n):
#     """Use the Sieve of Eratosthenes to produce all prime numbers from 2 through n.
#     Adapated from the wikipedia pseudocode."""

#     sieve = [True] * n

#     for i in range(2, int(math.sqrt(n)) + 1):
#         if sieve[i]:
#             for j in range(2 * i, n, i):
#                 sieve[j] = False

#     return [x for x in range(2, n) if sieve[x]]


# primes = prime_sieve(1000000)


def prime_factors(n):
    """Return the prime factors of all numbers up to n using the sieve of Eratosthenes."""

    sieve = [[] for _ in range(n)]
    sieve[0] = []

    for i in range(2, int(math.sqrt(n)) + 1):
        if sieve[i] == []:
            for j in range(2 * i, n, i):
                sieve[j].append(i)

    return sieve


factors = prime_factors(1000001)


def count_GCD(d):
    """Count the number of nums n < d such that GCD(n, d) = 1."""
    gcd = d - 1
    for factor in factors[d]:
        if factor < d // factor or factors[d // factor] != []:
            gcd -= (d // factor) - 1
    return gcd


def count(d):
    res = 0
    for n in range(1, d):
        if math.gcd(n, d) == 1:
            res += 1
    return res


if __name__ == "__main__":
    res = 0
    for d in range(2, 1000001):
        # print(d, count_GCD(d), count(d))
        res += count_GCD(d)
    print(res)
