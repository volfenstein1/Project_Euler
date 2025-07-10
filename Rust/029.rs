use num_bigint::BigUint;
use std::collections::HashSet;

fn generate_terms(a_max: u32, b_max: u32) -> usize {
    let mut terms = HashSet::new();
    for a in 2..=a_max {
        for b in 2..=b_max {
            terms.insert(BigUint::from(a).pow(b));
        }
    }
    terms.len()
}

fn main() {
    let res = generate_terms(100, 100);
    println!("{}", res);
}
