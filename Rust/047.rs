use std::collections::HashSet;

fn count_distinct_prime_factors(limit: usize) -> Vec<u32> {
    let mut distinct_prime_factors = vec![0; limit + 1];

    for i in 2..=limit {
        if distinct_prime_factors[i] == 0 { // i is prime
            for j in (i..=limit).step_by(i) {
                distinct_prime_factors[j] += 1;
            }
        }
    }
    distinct_prime_factors
}

fn main() {
    let limit = 1_000_000;
    let num_consecutive = 4;
    let required_distinct_factors = 4;

    let distinct_prime_factors = count_distinct_prime_factors(limit);

    for n in 2..=(limit - num_consecutive + 1) {
        let mut found_consecutive = true;
        for i in 0..num_consecutive {
            if distinct_prime_factors[n + i] != required_distinct_factors {
                found_consecutive = false;
                break;
            }
        }
        if found_consecutive {
            println!("{}", n);
            break;
        }
    }
}
