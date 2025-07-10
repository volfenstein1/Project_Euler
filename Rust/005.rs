fn gcd(a: u64, b: u64) -> u64 {
    if b == 0 {
        a
    } else {
        gcd(b, a % b)
    }
}

fn lcm(a: u64, b: u64) -> u64 {
    (a * b) / gcd(a, b)
}

fn main() {
    let mut result: u64 = 1;
    for i in 1..=20 {
        result = lcm(result, i);
    }
    println!("{}", result);
}
