use num_bigint::BigUint;

fn sum_digits(num: &BigUint) -> u32 {
    num.to_string().chars().map(|c| c.to_digit(10).unwrap()).sum()
}

fn main() {
    let base = BigUint::from(2u32);
    let power = 1000;
    let num = base.pow(power);
    println!("{}", sum_digits(&num));
}
