# It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal expansion of such square roots is infinite without any repeating pattern at all.
# The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.
# For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.

# Observation:
# Can group numbers together
#         2 + 4 + 6       + 8 + 10      + 12
# sqrt(2)(1 + 0 + sqrt(3) + 2 + sqrt(5) + sqrt(6))


# def precision_sqrt(n, precision):
#     """Caculate the square root of n to arbitrary precision (unrounded)."""
#     res = []

from sympy import sqrt


def sqrt_decimal_sum(n):
    x = str(sqrt(n).evalf(200))
    res = 0
    for digit in x[:101]:
        if digit != ".":
            res += int(digit)
    return res


print(sqrt_decimal_sum(2))

if __name__ == "__main__":
    res = 0
    for n in range(2, 101):
        if n not in [4, 9, 16, 25, 36, 49, 64, 81, 100]:
            res += sqrt_decimal_sum(n)
    print(res)
