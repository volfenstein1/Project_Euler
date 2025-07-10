use num_bigint::BigUint;

fn sum_digits(num: &BigUint) -> u32 {
    num.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum()
}

fn main() {
    let mut factorial = BigUint::from(1u32);
    for i in 1..=100 {
        factorial *= BigUint::from(i);
    }
    println!("{}", sum_digits(&factorial));
}
