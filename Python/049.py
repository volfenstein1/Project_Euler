# The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
# There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
# What 12-digit number do you form by concatenating the three terms in this sequence?

from itertools import permutations


def find_four_digit_primes():
    """Find all four digit prime numbers."""
    primes = []
    y = 2
    while y < 10000:
        if all(y % prime for prime in primes):
            primes.append(y)
        y += 1
    primes = set(prime for prime in primes if prime > 1000)
    return primes


def permute_digits(num):
    """Permute the digits of a number."""
    res = [int("".join(p)) for p in set(permutations(str(num)))]
    return res


def find_arithemetic_primes():
    res = []
    primes = find_four_digit_primes()
    for prime in primes:
        arithmetic_candidate = set()
        for num in permute_digits(prime):
            if num != prime and num in primes:
                arithmetic_candidate.add(num)

        for prime2 in arithmetic_candidate:
            if prime2 > prime:
                diff = prime2 - prime
                if prime + 2 * diff in arithmetic_candidate:
                    res.append([prime, prime + diff, prime + 2 * diff])

    return res


if __name__ == "__main__":
    print(find_arithemetic_primes())
