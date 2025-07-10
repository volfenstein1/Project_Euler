# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
#
# a^2 + b^2 = c^2.
#
# For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
# There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.


def pythagorean_triplet(a, b, c):
    return a**2 + b**2 == c**2


if __name__ == "__main__":
    for a in range(1, 1001):
        for b in range(a + 1, 1001 - a):
            c = 1000 - a - b
            if pythagorean_triplet(a, b, c):
                print("Product abc", a * b * c)
