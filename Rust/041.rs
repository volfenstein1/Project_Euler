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

fn is_pandigital(n: u32, num_digits: u32) -> bool {
    let s = n.to_string();
    if s.len() != num_digits as usize {
        return false;
    }

    let mut digits: Vec<char> = s.chars().collect();
    digits.sort_unstable();

    let expected_digits: String = (1..=num_digits).map(|d| d.to_string()).collect();
    digits.into_iter().collect::<String>() == expected_digits
}

fn main() {
    // The sum of digits 1-9 is 45 (divisible by 3).
    // The sum of digits 1-8 is 36 (divisible by 3).
    // So, 9-digit and 8-digit pandigital numbers are divisible by 3.
    // Thus, they cannot be prime (unless the number itself is 3, which is not 8 or 9 digits).
    // We only need to check 7-digit pandigital primes.
    let max_7_digit_pandigital = 7_654_321;
    let primes_set = sieve_of_eratosthenes(max_7_digit_pandigital as usize);

    let mut largest_pandigital_prime = 0;

    // Iterate downwards from the largest possible 7-digit number
    for n in (1_000_000..=max_7_digit_pandigital).rev() {
        if primes_set.contains(&n) && is_pandigital(n, 7) {
            largest_pandigital_prime = n;
            break;
        }
    }

    println!("Largest 7-digit pandigital prime: {}", largest_pandigital_prime);
}
