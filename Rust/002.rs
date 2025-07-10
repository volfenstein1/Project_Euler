fn fibonacci_sum(b: u64) -> u64 {
    let mut f1: u64 = 1;
    let mut f2: u64 = 1;
    let mut sum_even: u64 = 0;

    while f2 < b {
        let next_f = f1 + f2;
        f1 = f2;
        f2 = next_f;
        if f2 % 2 == 0 {
            sum_even += f2;
        }
    }
    sum_even
}

fn main() {
    let bound: u64 = 4_000_000;
    println!("{}", fibonacci_sum(bound));
}
