# The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28. In fact, there are exactly four numbers below fifty that can be expressed in such a way:
#
# 28 = 2^2 + 2^3 + 2^4
# 33 = 3^2 + 2^3 + 2^4
# 49 = 5^2 + 2^3 + 2^4
# 47 = 2^2 + 3^3 + 2^4
#
# How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?

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


if __name__ == "__main__":
    primes = prime_sieve(1000000)
    expressable_numbers = set()
    bound = 50000000

    for prime4 in primes:
        if prime4**4 >= bound:
            break
        for prime3 in primes:
            if prime3**3 >= bound:
                break
            for prime2 in primes:
                if prime2**2 >= bound:
                    break
                n = prime2**2 + prime3**3 + prime4**4
                if n <= bound:
                    expressable_numbers.add(n)

    print(len(expressable_numbers))
