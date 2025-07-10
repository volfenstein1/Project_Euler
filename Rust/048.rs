use num_bigint::BigUint;

fn main() {
    let bound = 1000;
    let modulus = BigUint::from(10_000_000_000u64);
    let mut total_sum = BigUint::from(0u32);

    for i in 1..=bound {
        let base = BigUint::from(i);
        let exponent = i as u32;
        let term = base.modpow(&BigUint::from(exponent), &modulus);
        total_sum = (total_sum + term) % &modulus;
    }

    println!("{}", total_sum);
}
