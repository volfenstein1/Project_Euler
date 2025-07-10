use std::collections::HashMap;

fn collatz_length(n: u64, lengths: &mut HashMap<u64, u32>) -> u32 {
    if let Some(&len) = lengths.get(&n) {
        return len;
    }

    let len = if n % 2 == 0 {
        1 + collatz_length(n / 2, lengths)
    } else {
        1 + collatz_length(3 * n + 1, lengths)
    };

    lengths.insert(n, len);
    len
}

fn main() {
    let mut lengths: HashMap<u64, u32> = HashMap::new();
    lengths.insert(1, 1);

    let mut num_with_longest_length: u64 = 0;
    let mut longest_length: u32 = 0;

    for n in 1..1_000_000 {
        let current_length = collatz_length(n, &mut lengths);
        if current_length > longest_length {
            longest_length = current_length;
            num_with_longest_length = n;
        }
    }

    println!("{}", num_with_longest_length);
}
