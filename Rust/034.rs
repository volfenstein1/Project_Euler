fn factorial(n: u32) -> u32 {
    (1..=n).product()
}

fn sum_factorial_digits(mut num: u32) -> u32 {
    let mut sum = 0;
    if num == 0 {
        return factorial(0);
    }
    while num > 0 {
        let digit = num % 10;
        sum += factorial(digit);
        num /= 10;
    }
    sum
}

fn main() {
    let mut res = 0;
    for n in 3..100_000 {
        if n == sum_factorial_digits(n) {
            res += n;
        }
    }
    println!("{}", res);
}
