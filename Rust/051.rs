use std::collections::HashSet;

fn sieve_of_eratosthenes(limit: usize) -> Vec<u32> {
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

    let mut primes = Vec::new();
    for (i, &prime) in is_prime.iter().enumerate() {
        if prime {
            primes.push(i as u32);
        }
    }
    primes
}

fn digit_replace(n: u32, primes_set: &HashSet<u32>) -> bool {
    let s = n.to_string();
    let chars: Vec<char> = s.chars().collect();
    let len = chars.len();

    let mut unique_digits_in_n = HashSet::new();
    for &c in &chars {
        unique_digits_in_n.insert(c);
    }

    for &digit_to_replace_char in &unique_digits_in_n {
        let mut prime_count = 0;
        for i in 0..=9 { // Replacement digit
            let replacement_digit_char = std::char::from_digit(i, 10).unwrap();

            let mut temp_s_chars = chars.clone();
            let mut replaced_at_first_pos = false;
            let mut replaced_any = false;

            for k in 0..len {
                if temp_s_chars[k] == digit_to_replace_char {
                    if k == 0 { // Check if the first digit is being replaced
                        replaced_at_first_pos = true;
                    }
                    temp_s_chars[k] = replacement_digit_char;
                    replaced_any = true;
                }
            }

            if !replaced_any {
                continue;
            }

            if replaced_at_first_pos && replacement_digit_char == '0' && len > 1 {
                continue;
            }

            let temp_s: String = temp_s_chars.into_iter().collect();
            let num = temp_s.parse::<u32>().unwrap();

            if primes_set.contains(&num) {
                prime_count += 1;
            }
        }
        if prime_count == 8 {
            return true;
        }
    }
    false
}

fn main() {
    let limit = 10_000_000;
    let primes_vec = sieve_of_eratosthenes(limit);
    let primes_set: HashSet<u32> = primes_vec.into_iter().collect();

    for prime in primes_set.iter().cloned() {
        // Skip single-digit primes as they cannot form families by replacing digits
        if prime < 10 {
            continue;
        }
        if digit_replace(prime, &primes_set) {
            println!("{}", prime);
            break; // Found the smallest
        }
    }
}
