# The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
# Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
# NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.


import math


def prime_sieve(n):
    """Use the Sieve of Eratosthenes to produce all prime numbers from 2 through n.
    Adapated from the wikipedia pseudocode."""

    sieve = [True] * n

    for i in range(2, int(math.sqrt(n)) + 1):
        if sieve[i]:
            for j in range(2 * i, n, i):
                sieve[j] = False

    return {x for x in range(2, n) if sieve[x]}


def truncatable(n):
    n = str(n)
    for idx in range(1, len(n)):
        if int(n[:idx]) not in primes or int(n[idx:]) not in primes:
            return False
    return True


if __name__ == "__main__":
    count = 0
    truncatable_primes_sum = 0
    primes = prime_sieve(10000000)
    for n in primes:
        if n not in {2, 3, 5, 7} and truncatable(n):
            count += 1
            truncatable_primes_sum += n
        if count == 11:
            print(truncatable_primes_sum)
            break
