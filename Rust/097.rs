use num_bigint::BigUint;

fn main() {
    let base = BigUint::from(2u32);
    let exponent = BigUint::from(7830457u32);
    let multiplier = BigUint::from(28433u32);
    let modulus = BigUint::from(10_000_000_000u64);

    // Calculate 2^7830457 % 10^10
    let power_of_two_mod = base.modpow(&exponent, &modulus);

    // Calculate (28433 * (2^7830457 % 10^10)) % 10^10
    let term1 = (&multiplier * &power_of_two_mod) % &modulus;

    // Add 1 and take modulus again
    let result = (&term1 + BigUint::from(1u32)) % &modulus;

    println!("{}", result);
}
