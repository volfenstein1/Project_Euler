use rug::{Float, ops::Pow};

fn sqrt_decimal_sum(n: u32) -> u32 {
    // Set precision to 100 decimal digits + some buffer for calculation accuracy
    let precision = 100 + 5; 
    let f_n = Float::with_val(precision, n);
    let sqrt_n = f_n.sqrt();

    let s = sqrt_n.to_string_radix(10, Some(100));
    let mut res = 0;
    for digit_char in s.chars() {
        if digit_char == '.' {
            continue;
        }
        res += digit_char.to_digit(10).unwrap();
    }
    res
}

fn main() {
    let mut total_sum = 0;
    for n in 2..=100 {
        let is_perfect_square = {
            let root = (n as f64).sqrt() as u32;
            root * root == n
        };

        if !is_perfect_square {
            total_sum += sqrt_decimal_sum(n);
        }
    }
    println!("{}", total_sum);
}
