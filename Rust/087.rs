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

fn main() {
    let bound: u64 = 50_000_000;
    // The maximum prime needed for the square term is sqrt(50,000,000) approx 7071.
    // The maximum prime needed for the cube term is cbrt(50,000,000) approx 368.
    // The maximum prime needed for the fourth power term is (50,000,000)^(1/4) approx 47.
    // So, a sieve up to 7100 is sufficient.
    let primes = sieve_of_eratosthenes(7100);

    let mut expressable_numbers: HashSet<u64> = HashSet::new();

    for &prime4 in &primes {
        let term4 = (prime4 as u64).pow(4);
        if term4 >= bound {
            break;
        }
        for &prime3 in &primes {
            let term3 = (prime3 as u64).pow(3);
            if term3 >= bound {
                break;
            }
            for &prime2 in &primes {
                let term2 = (prime2 as u64).pow(2);
                if term2 >= bound {
                    break;
                }

                let n = term2 + term3 + term4;
                if n < bound {
                    expressable_numbers.insert(n);
                }
            }
        }
    }
    println!("{}", expressable_numbers.len());
}
