# If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
# If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
# NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.


def num_to_word(n):
    """Converts the number to the corresponding written word."""
    if n == 1000:
        return "onethousand"
    digits_to_word = {
        1: "one",
        2: "two",
        3: "three",
        4: "four",
        5: "five",
        6: "six",
        7: "seven",
        8: "eight",
        9: "nine",
    }
    teens_to_word = {
        10: "ten",
        11: "eleven",
        12: "twelve",
        13: "thirteen",
        14: "fourteen",
        15: "fifteen",
        16: "sixteen",
        17: "seventeen",
        18: "eighteen",
        19: "nineteen",
    }
    tens_to_word = {
        2: "twenty",
        3: "thirty",
        4: "forty",
        5: "fifty",
        6: "sixty",
        7: "seventy",
        8: "eighty",
        9: "ninety",
    }
    res = ""
    hundreds = n // 100
    n %= 100
    if hundreds:
        res += digits_to_word[hundreds] + "hundred"
        if n == 0:
            return res
        else:
            res += "and"
    if 10 <= n < 20:
        res += teens_to_word[n]
        return res
    tens = n // 10
    n %= 10
    if tens:
        res += tens_to_word[tens]
        if n == 0:
            return res
    ones = n
    res += digits_to_word[ones]
    return res


if __name__ == "__main__":
    res = 0
    for n in range(1, 1001):
        print(n, num_to_word(n))
        res += len(num_to_word(n))
    print(res)
