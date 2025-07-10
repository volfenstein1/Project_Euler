fn main() {
    let limit = 1_000_000;
    let mut phi: Vec<u32> = (0..=limit as u32).collect();

    for i in 2..=limit {
        if phi[i] == i as u32 { // i is prime
            for j in (i..=limit).step_by(i) {
                phi[j] -= phi[j] / (i as u32);
            }
        }
    }

    let total_count: u64 = phi.iter().skip(2).map(|&x| x as u64).sum();

    println!("{}", total_count);
}
