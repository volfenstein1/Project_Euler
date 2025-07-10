# The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
# There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
# How many circular primes are there below one million?


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


primes = prime_sieve(1000000)
prime_set = set(primes)


def circular_prime(n):
    """Checks if the prime n is a circular prime."""
    s = str(n)
    for idx in range(len(s)):
        if int(s[idx:] + s[:idx]) not in prime_set:
            return False
    return True


if __name__ == "__main__":
    res = 0
    for prime in primes:
        if circular_prime(prime):
            res += 1
    print(res)
