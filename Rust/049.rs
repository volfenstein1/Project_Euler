use std::collections::{HashSet, BTreeSet};

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

fn get_digits(n: u32) -> BTreeSet<char> {
    n.to_string().chars().collect()
}

fn main() {
    let primes_set = sieve_of_eratosthenes(9999);

    // Filter for 4-digit primes
    let four_digit_primes: Vec<u32> = primes_set.iter()
        .filter(|&&p| p >= 1000 && p <= 9999)
        .cloned()
        .collect();

    for &p1 in &four_digit_primes {
        let digits1 = get_digits(p1);

        for &p2 in &four_digit_primes {
            if p2 <= p1 { continue; }

            let digits2 = get_digits(p2);
            if digits1 != digits2 { continue; }

            let diff = p2 - p1;
            let p3 = p2 + diff;

            if p3 <= 9999 && primes_set.contains(&p3) {
                let digits3 = get_digits(p3);
                if digits1 == digits3 {
                    // Found the sequence. The problem states there's only one other.
                    // The example sequence is 1487, 4817, 8147.
                    // The problem asks for the 12-digit number formed by concatenating the three terms.
                    // The example sequence is 148748178147.
                    if p1 != 1487 {
                        println!("{}{}{}", p1, p2, p3);
                        return;
                    }
                }
            }
        }
    }
}
