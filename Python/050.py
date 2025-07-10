# The prime 41, can be written as the sum of six consecutive primes:
#
# 41 = 2 + 3 + 5 + 7 + 11 + 13.
#
# This is the longest sum of consecutive primes that adds to a prime below one-hundred.
# The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
# Which prime, below one-million, can be written as the sum of the most consecutive primes?


def find_primes_bounded(bound):
    """Find all prime numbers less than or equal to bound."""
    primes = []
    y = 2
    while y <= bound:
        if all(y % prime for prime in primes):
            primes.append(y)
            print("New prime found", y)
        y += 1
    return primes


def find_consecutive(primes, bound):
    """Given a list of primes, find the prime which can be written as the most consecutive primes."""
    running_sum = [primes[0]]
    for prime in primes[1:]:
        running_sum.append(running_sum[-1] + prime)
    primes = set(primes)

    num_summands = 0
    prime_sum = 0

    for idx_x, x in enumerate(running_sum):
        for idx_y, y in enumerate(running_sum[idx_x + 1 :]):
            print(x, y)
            if y - x in primes and idx_y + 1 > num_summands:
                num_summands = idx_y + 1
                prime_sum = y - x
                print(
                    "New prime found",
                    prime_sum,
                    "sum of",
                    num_summands,
                    "primes",
                )
            elif y - x > bound:
                break
    return prime_sum


if __name__ == "__main__":
    primes = find_primes_bounded(1000000)
    prime_sum = find_consecutive(primes, 1000000)
    print("Prime which is the sum of the most consecutive primes", prime_sum)
