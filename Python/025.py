# The Fibonacci sequence is defined by the recurrence relation:
#
# F_n = F_{n - 1} + F_{n - 2}, where F_1 = 1 and F_2 = 1.
#
# Hence the first $12$ terms will be:
#
# F_1 = 1
# F_2 = 1
# F_3 = 2
# F_4 = 3
# F_5 = 5
# F_6 = 8
# F_7 = 13
# F_8 = 21
# F_9 = 34
# F_{10} = 55
# F_{11} = 89
# F_{12} = 144
#
# The 12th term, F_{12}, is the first term to contain three digits.
# What is the index of the first term in the Fibonacci sequence to contain 1000 digits?


def num_digits(x):
    z = 0
    while 10**z < x:
        z += 1
    return z


def fibonnaci_index(digits):
    f_1 = 1
    f_2 = 1
    index = 2
    while num_digits(f_2) < digits:
        index += 1
        f_2, f_1 = f_2 + f_1, f_2
    return index


if __name__ == "__main__":
    digits = 1000

    print(fibonnaci_index(digits))
