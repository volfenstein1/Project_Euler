# The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
# We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
# There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
# If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

import math


def cancel(numerator, denominator):
    if numerator // 10 == denominator // 10:
        return (numerator % 10) / (denominator % 10)
    elif numerator % 10 == denominator % 10 and numerator % 10 != 0:
        return (numerator // 10) / (denominator // 10)
    elif numerator // 10 == denominator % 10:
        return (numerator % 10) / (denominator // 10)
    elif numerator % 10 == denominator // 10 and denominator % 10 != 0:
        return (numerator // 10) / (denominator % 10)
    else:
        return -1


if __name__ == "__main__":
    res_numerator = 1
    res_denominator = 1
    for numerator in range(10, 100):
        for denominator in range(numerator + 1, 100):
            if numerator / denominator == cancel(numerator, denominator):
                res_numerator *= numerator
                res_denominator *= denominator
    res_denominator //= math.gcd(res_numerator, res_denominator)
    print(res_denominator)
