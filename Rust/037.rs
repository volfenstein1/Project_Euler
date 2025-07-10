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

fn is_truncatable_prime(n: u32, primes_set: &HashSet<u32>) -> bool {
    let s = n.to_string();
    let len = s.len();

    // Check left-to-right truncations
    for i in 1..len {
        let truncated_s = &s[i..];
        if !primes_set.contains(&truncated_s.parse::<u32>().unwrap()) {
            return false;
        }
    }

    // Check right-to-left truncations
    for i in (1..len).rev() {
        let truncated_s = &s[0..i];
        if !primes_set.contains(&truncated_s.parse::<u32>().unwrap()) {
            return false;
        }
    }
    true
}

fn main() {
    let limit = 10_000_000;
    let primes_set = sieve_of_eratosthenes(limit);

    let mut count = 0;
    let mut truncatable_primes_sum: u64 = 0;

    // Start checking from 10, as 2, 3, 5, 7 are explicitly excluded
    for n in 10..limit {
        if primes_set.contains(&n) {
            if is_truncatable_prime(n, &primes_set) {
                count += 1;
                truncatable_primes_sum += n as u64;
                if count == 11 {
                    break;
                }
            }
        }
    }
    println!("{}", truncatable_primes_sum);
}
