# The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 2^{6972593} - 1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p - 1, have been found which contain more digits.
# However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433 x 2^{7830457} + 1.
# Find the last ten digits of this prime number.


def last_digits(power):
    """Return last 10 digits of 2**power."""
    if power < 100:
        return (2**power) % (10**10)
    two_x = 2
    x = 1
    while 2 * x <= power:
        two_x *= two_x
        two_x %= 10**10
        x *= 2
    remainder = power - x
    two_x *= last_digits(remainder)
    return two_x % (10**10)


if __name__ == "__main__":
    last_digits_non_mersenne_prime = (28433 * last_digits(7830457) + 1) % (
        10**10
    )
    print(last_digits_non_mersenne_prime)
