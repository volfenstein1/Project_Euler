# The series, 1^1 + 2^2 + 3^3 + ... + 10^{10} = 10405071317.
# Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^{1000}.


def digits_self_powers(bound):
    res = 0
    for x in range(1, bound + 1):
        res += (x**x) % 10000000000
        res %= 10000000000
    return res


if __name__ == "__main__":
    bound = 1000

    print(digits_self_powers(bound))
