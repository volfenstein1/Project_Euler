fn prime_sieve(n: usize) -> u64 {
    let mut sieve = vec![true; n];
    sieve[0] = false;
    sieve[1] = false;

    for i in 2..{
        if i * i >= n {
            break;
        }
        if sieve[i] {
            for j in (2 * i..n).step_by(i) {
                sieve[j] = false;
            }
        }
    }

    let mut sum_of_primes: u64 = 0;
    for (i, &is_prime) in sieve.iter().enumerate() {
        if is_prime {
            sum_of_primes += i as u64;
        }
    }
    sum_of_primes
}

fn main() {
    let bound: usize = 2_000_000;
    let sum_of_primes = prime_sieve(bound);
    println!("Sum of primes below two million: {}", sum_of_primes);
}
