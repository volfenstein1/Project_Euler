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

fn find_consecutive(primes: &[u32], bound: u32) -> u32 {
    let prime_set: HashSet<u32> = primes.iter().cloned().collect();
    let mut running_sum: Vec<u64> = vec![0; primes.len() + 1];
    for i in 0..primes.len() {
        running_sum[i + 1] = running_sum[i] + primes[i] as u64;
    }

    let mut max_len = 0;
    let mut result_prime = 0;

    for i in 0..running_sum.len() {
        for j in (i + 1)..running_sum.len() {
            let sum = running_sum[j] - running_sum[i];
            let len = j - i;

            if sum > bound as u64 {
                break;
            }

            if len > max_len && prime_set.contains(&(sum as u32)) {
                max_len = len;
                result_prime = sum as u32;
            }
        }
    }
    result_prime
}

fn main() {
    let bound = 1_000_000;
    let primes = sieve_of_eratosthenes(bound);
    let prime_sum = find_consecutive(&primes, bound);
    println!("Prime which is the sum of the most consecutive primes: {}", prime_sum);
}
