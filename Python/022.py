# Using names.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
# For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 x 53 = 49714.
# What is the total of all the name scores in the file?


def name_score(name):
    score = 0
    for char in name:
        score += ord(char) - ord("A") + 1
    return score


if __name__ == "__main__":
    with open("names.txt") as file:
        data = file.read().strip().replace('"', "").split(",")

    data.sort()

    res = 0
    for idx, name in enumerate(data):
        res += (idx + 1) * name_score(name)

    print(res)
