# 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
# What is the smallest positive number that is evenly divisible (divisible with no remainder) by all of the numbers from 1 to 20?


def no_remainder(nums):
    """Find the smallest number evenly divisible by all numbers in nums."""
    x = 1
    while any(x != num * (x // num) for num in nums):
        x += 1
    return x


if __name__ == "__main__":
    nums = [x for x in range(1, 17)]
    print(no_remainder(nums) * 17 * 19)
