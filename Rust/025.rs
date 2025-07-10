use num_bigint::BigUint;
use std::str::FromStr;

fn main() {
    let digits = 1000;
    let mut f1 = BigUint::from_str("1").unwrap();
    let mut f2 = BigUint::from_str("1").unwrap();
    let mut index = 2;

    while f2.to_string().len() < digits {
        let temp = f2.clone();
        f2 = &f2 + &f1;
        f1 = temp;
        index += 1;
    }

    println!("{}", index);
}
