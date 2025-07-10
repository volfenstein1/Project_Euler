# The following iterative sequence is defined for the set of positive integers:
#
# n -> n/2 (n is even)
# n -> 3n + 1 (n is odd)
#
# Using the rule above and starting with 13, we generate the following sequence:
#
# 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1.
#
# It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
# Which starting number, under one million, produces the longest chain?
# NOTE: Once the chain starts the terms are allowed to go above one million.

lengths = {}
lengths[1] = 1


def collatz_length(n):
    """Compute the length of the chain starting at n."""
    if n not in lengths:
        if not (n % 2):
            lengths[n] = 1 + collatz_length(n // 2)
        if n % 2:
            lengths[n] = 1 + collatz_length(3 * n + 1)
    return lengths[n]


if __name__ == "__main__":
    num_with_longest_length = 0
    longest_length = 0
    for n in range(1, 1000000):
        if collatz_length(n) > longest_length:
            num_with_longest_length = n
            longest_length = collatz_length(n)
    print(num_with_longest_length)
