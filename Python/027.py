# Euler discovered the remarkable quadratic formula:
#
# n^2 + n + 41
#
# It turns out that the formula will produce 40 primes for the consecutive integer values 0 <= n <= 39. However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly divisible by 41.
# The incredible formula n^2 - 79n + 1601 was discovered, which produces 80 primes for the consecutive values 0 <= n <= 79. The product of the coefficients, -79 and 1601, is -126479.
# Considering quadratics of the form:
#
# n^2 + an + b, where |a| < 1000 and |b| <= 1000 where |n| is the modulus/absolute value of n, e.g., |11| = 11 and |-4| = 4
#
# Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.

import math


def prime_sieve(n):
    """Use the Sieve of Eratosthenes to produce all prime numbers from 2 through n.
    Adapated from the wikipedia pseudocode."""

    sieve = [True] * n

    for i in range(2, int(math.sqrt(n)) + 1):
        if sieve[i]:
            for j in range(2 * i, n, i):
                sieve[j] = False

    return [x for x in range(2, n) if sieve[x]]


primes = prime_sieve(2000000)


def consecutive_primes(a, b):
    n = 0
    while (n**2 + a * n + b) in primes:
        n += 1
    return n


if __name__ == "__main__":
    max_consectuive_primes = 0
    b_range = [prime for prime in primes if prime <= 1000]
    for a in range(-999, 1000, 2):
        for b in b_range:
            print(a, b)
            if consecutive_primes(a, b) > max_consectuive_primes:
                max_consectuive_primes = consecutive_primes(a, b)
                res = a * b

    print("Product of a, b", res)
