use std::collections::HashSet;

fn is_pentagonal(num: u32) -> bool {
    let test = 1 + 24 * num as u64;
    let sqrt_test = (test as f64).sqrt() as u64;
    if sqrt_test * sqrt_test != test {
        return false;
    }
    (1 + sqrt_test) % 6 == 0
}

fn main() {
    let mut pentagonal_numbers: Vec<u32> = Vec::new();
    let mut pentagonal_set: HashSet<u32> = HashSet::new();

    // Generate pentagonal numbers up to a certain limit
    // The problem implies that the numbers won't be excessively large.
    // A limit of 60,000 for n should be sufficient to find the answer.
    // P_60000 = 60000 * (3 * 60000 - 1) / 2 = 5,399,910,000
    // This is within u32 range.
    for n in 1..60000 {
        let p_n = n * (3 * n - 1) / 2;
        pentagonal_numbers.push(p_n);
        pentagonal_set.insert(p_n);
    }

    let mut min_diff = u32::MAX;

    // Iterate through pairs of pentagonal numbers
    for i in 0..pentagonal_numbers.len() {
        for j in (i + 1)..pentagonal_numbers.len() {
            let pj = pentagonal_numbers[i];
            let pk = pentagonal_numbers[j];

            let sum = pj + pk;
            let diff = pk - pj;

            if is_pentagonal(sum) && is_pentagonal(diff) {
                if diff < min_diff {
                    min_diff = diff;
                }
            }
        }
    }

    println!("{}", min_diff);
}
