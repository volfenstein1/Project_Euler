fn is_palindrome(num: u32) -> bool {
    let s = num.to_string();
    let chars: Vec<char> = s.chars().collect();
    let n = chars.len();
    for i in 0..n / 2 {
        if chars[i] != chars[n - 1 - i] {
            return false;
        }
    }
    true
}

fn main() {
    let mut res: u32 = 0;
    for x in (100..1000).rev() {
        for y in (100..1000).rev() {
            let product = x * y;
            if product < res {
                break;
            }
            if is_palindrome(product) {
                res = product;
            }
        }
    }
    println!("Largest palindrome: {}", res);
}
