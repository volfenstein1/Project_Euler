const DIGITS_TO_WORD: [&str; 10] = [
    "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
];
const TEENS_TO_WORD: [&str; 10] = [
    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
    "eighteen", "nineteen",
];
const TENS_TO_WORD: [&str; 10] = [
    "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
];

fn num_to_word(n: u32) -> String {
    if n == 1000 {
        return "onethousand".to_string();
    }

    let mut res = String::new();
    let hundreds = n / 100;
    let mut remainder = n % 100;

    if hundreds > 0 {
        res.push_str(DIGITS_TO_WORD[hundreds as usize]);
        res.push_str("hundred");
        if remainder > 0 {
            res.push_str("and");
        }
    }

    if remainder >= 10 && remainder < 20 {
        res.push_str(TEENS_TO_WORD[(remainder - 10) as usize]);
    } else {
        let tens = remainder / 10;
        let ones = remainder % 10;
        if tens > 0 {
            res.push_str(TENS_TO_WORD[tens as usize]);
        }
        if ones > 0 {
            res.push_str(DIGITS_TO_WORD[ones as usize]);
        }
    }
    res
}

fn main() {
    let mut total_letters = 0;
    for n in 1..=1000 {
        let word = num_to_word(n);
        total_letters += word.len();
    }
    println!("{}", total_letters);
}
