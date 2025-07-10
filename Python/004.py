# A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 x 99.
# Find the largest palindrome made from the product of two 3-digit numbers.

import math


def is_palindrome(num):
    """Check if a num is a palindrome."""
    s = str(num)
    for idx in range(len(s) // 2):
        if s[idx] != s[len(s) - 1 - idx]:
            return False
    return True


if __name__ == "__main__":
    res = -math.inf
    for x in range(999, 100, -1):
        for y in range(999, 100, -1):
            if x * y < res:
                break
            if is_palindrome(x * y):
                res = x * y
    print("Largest palindrome", res)
