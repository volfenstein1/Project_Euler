# We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
# What is the largest n-digit pandigital prime that exists?

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


primes = prime_sieve(10**7)
primes = [prime for prime in primes if prime > 10**6]


def pandigital(prime):
    return set(str(prime)) == {str(x) for x in range(1, 8)}


if __name__ == "__main__":
    # Notice that a pandigital prime cannot have digits 1-9 or 1-8, as the sum of both digits is divisible by 3.
    # Hence the number cannot be prime.
    # So check for 7-digit pandigital primes.
    for prime in primes[::-1]:
        if pandigital(prime):
            print("Largest 7-digit pandigital prime", prime)
            break
