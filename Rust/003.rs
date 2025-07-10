fn prime_factor(mut x: u64) -> Vec<u64> {
    let mut divisors = Vec::new();
    let mut y: u64 = 2;
    while y * y < x {
        if x % y == 0 {
            x /= y;
            divisors.push(y);
            println!("Divisor found: {}", y);
        } else {
            y += 1;
        }
    }
    divisors.push(x);
    println!("Final divisor: {}", x);
    divisors
}

fn main() {
    let x: u64 = 600851475143;
    println!("{:?}", prime_factor(x));
}
