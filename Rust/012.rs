fn count_divisors(n: u64) -> u32 {
    let mut count = 0;
    let limit = (n as f64).sqrt() as u64;

    for i in 1..=limit {
        if n % i == 0 {
            if n / i == i {
                count += 1;
            } else {
                count += 2;
            }
        }
    }
    count
}

fn main() {
    let mut n: u64 = 1;
    loop {
        let triangle_number = n * (n + 1) / 2;
        if count_divisors(triangle_number) >= 500 {
            println!("{}", triangle_number);
            break;
        }
        n += 1;
    }
}
