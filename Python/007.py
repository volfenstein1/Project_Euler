# By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
# What is the 10,001st prime number?


def find_primes(x):
    """Find the first x prime numbers."""
    primes = []
    y = 2
    while len(primes) < x:
        if all(y % prime for prime in primes):
            print("Prime found:", y)
            primes.append(y)
        y += 1
    return primes


if __name__ == "__main__":
    x = 10001
    print(f"{x}st prime: {find_primes(x)[-1]}")
