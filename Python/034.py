# 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
# Find the sum of all numbers which are equal to the sum of the factorial of their digits.
# Note: As 1! = 1 and 2! = 2 are not sums they are not included.

import math


def sum_factorial_digits(num):
    s = str(num)
    res = 0
    for digit in s:
        res += math.factorial(int(digit))
    return res


if __name__ == "__main__":
    res = 0
    for n in range(3, 100000):
        if n == sum_factorial_digits(n):
            res += n
    print(res)
