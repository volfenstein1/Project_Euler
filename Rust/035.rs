use std::collections::HashSet;

fn sieve_of_eratosthenes(limit: usize) -> HashSet<u32> {
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
            primes.insert(i as u32);
        }
    }
    primes
}

fn is_circular_prime(n: u32, prime_set: &HashSet<u32>) -> bool {
    let s = n.to_string();
    let len = s.len();
    for i in 0..len {
        let rotated_s = format!("{}{}", &s[i..], &s[0..i]);
        let rotated_num = rotated_s.parse::<u32>().unwrap();
        if !prime_set.contains(&rotated_num) {
            return false;
        }
    }
    true
}

fn main() {
    let limit = 1_000_000;
    let primes = sieve_of_eratosthenes(limit);

    let mut count = 0;
    for &prime in &primes {
        if is_circular_prime(prime, &primes) {
            count += 1;
        }
    }
    println!("{}", count);
}
