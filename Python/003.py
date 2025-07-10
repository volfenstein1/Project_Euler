# The prime factors of 13195 are 5, 7, 13 and 29.
# What is the largest prime factor of the number 600851475143?


def prime_factor(x):
    divisors = []
    y = 2
    while y**2 < x:
        if not x % y:
            x //= y
            divisors.append(y)
            print("Divisor found:", y)
        else:
            y += 1
    divisors.append(x)
    print("Final divisor:", x)
    return divisors


if __name__ == "__main__":
    x = 600851475143
    print(prime_factor(x))
