use std::collections::HashSet;

fn sieve_of_eratosthenes(limit: usize) -> HashSet<i32> {
    let mut is_prime = vec![true; limit + 1];
    if limit >= 0 { is_prime[0] = false; }
    if limit >= 1 { is_prime[1] = false; }

    for p in 2..=limit {
        if p * p > limit { // Optimization: only iterate up to sqrt(limit)
            break;
        }
        if is_prime[p] {
            for multiple in (p * p..=limit).step_by(p) {
                is_prime[multiple] = false;
            }
        }
    }

    let mut primes = HashSet::new();
    for (i, &prime) in is_prime.iter().enumerate() {
        if prime {
            primes.insert(i as i32);
        }
    }
    primes
}

fn consecutive_primes(a: i32, b: i32, primes_set: &HashSet<i32>) -> u32 {
    let mut n = 0;
    loop {
        let val = n * n + a * n + b;
        if val < 0 || !primes_set.contains(&val) {
            break;
        }
        n += 1;
    }
    n as u32
}

fn main() {
    let primes_limit = 2_000_000;
    let primes = sieve_of_eratosthenes(primes_limit);

    let mut max_consecutive_primes = 0;
    let mut result_product = 0;

    let b_range: Vec<i32> = primes.iter().filter(|&&p| p <= 1000).cloned().collect();

    for a in -999..1000 {
        for &b in &b_range {
            // Optimization: if n=0, b must be prime. If n=1, 1+a+b must be prime.
            // The original Python code implicitly handles b being prime because b_range is filtered.
            // For n=1, 1+a+b must be prime. If a is even, 1+a is odd. If b is odd, 1+a+b is even.
            // If b is 2, 1+a+2 = 3+a. If a is odd, 3+a is even. So if b=2, a must be even.
            // If b is odd, a must be odd for 1+a+b to be even (and thus not prime, unless it's 2).
            // Given b is prime, b=2 is the only even prime. If b=2, then 1+a+2 = 3+a. If a is odd, 3+a is even.
            // So if b=2, a must be even. If b is odd prime, a must be odd.
            // The Python code iterates a from -999 to 999 with step 2, meaning a is always odd.
            // This implies that if b is an odd prime, 1+a+b will be even. This is only prime if 1+a+b = 2.
            // So, if b is an odd prime, and 1+a+b is prime, then 1+a+b must be 2. This means a = 1-b.
            // This is a strong constraint. Let's stick to the original Python logic for now.

            let current_consecutive_primes = consecutive_primes(a, b, &primes);
            if current_consecutive_primes > max_consecutive_primes {
                max_consecutive_primes = current_consecutive_primes;
                result_product = a * b;
            }
        }
    }

    println!("Product of a, b: {}", result_product);
}
