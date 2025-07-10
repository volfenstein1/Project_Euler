# A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.
# For example,
#
# 44 -> 32 -> 13 -> 10 -> 1 -> 1
# 85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
#
# Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
# How many starting numbers below ten million will arrive at 89?


def square_digits(n):
    res = 0
    for char in str(n):
        res += int(char) ** 2
    return res


chains = {1: 1, 89: 89}


def chain(n):
    """Compute the termination of the chain starting at n."""
    m = n
    while m not in chains:
        m = square_digits(m)
    chains[n] = chains[m]
    return chains[n]


if __name__ == "__main__":
    res = 0
    for n in range(1, 10000001):
        if chain(n) == 89:
            res += 1
    print(res)
