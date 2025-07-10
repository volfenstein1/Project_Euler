fn is_pythagorean_triplet(a: u32, b: u32, c: u32) -> bool {
    (a as u64).pow(2) + (b as u64).pow(2) == (c as u64).pow(2)
}

fn main() {
    for a in 1..1000 {
        for b in (a + 1)..(1000 - a) {
            let c = 1000 - a - b;
            if is_pythagorean_triplet(a, b, c) {
                println!("Product abc: {}", (a as u64) * (b as u64) * (c as u64));
                return;
            }
        }
    }
}
