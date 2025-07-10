fn find_primes(x: usize) -> Vec<u64> {
    let mut primes: Vec<u64> = Vec::new();
    let mut y: u64 = 2;

    while primes.len() < x {
        let mut is_prime = true;
        for &prime in &primes {
            if y % prime == 0 {
                is_prime = false;
                break;
            }
        }
        if is_prime {
            println!("Prime found: {}", y);
            primes.push(y);
        }
        y += 1;
    }
    primes
}

fn main() {
    let x: usize = 10001;
    let primes = find_primes(x);
    println!("{}st prime: {}", x, primes[x - 1]);
}
