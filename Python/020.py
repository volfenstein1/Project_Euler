# n! means n x (n - 1) x ... x 3 x 2 x 1.
# For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800, and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
# Find the sum of the digits in the number 100!.


def sum_digits(num):
    s = str(num)
    res = 0
    for digit in s:
        res += int(digit)
    return res


if __name__ == "__main__":
    product = 1
    for n in range(1, 101):
        while not n % 5:
            n //= 5
            product //= 2
        product *= n
    print(sum_digits(product))
