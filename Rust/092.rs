use std::collections::HashMap;

fn square_digits(mut n: u32) -> u32 {
    let mut sum = 0;
    while n > 0 {
        let digit = n % 10;
        sum += digit * digit;
        n /= 10;
    }
    sum
}

fn chain(n: u32, chains: &mut HashMap<u32, u32>) -> u32 {
    if let Some(&result) = chains.get(&n) {
        return result;
    }

    let mut current_num = n;
    let mut path = Vec::new();

    while !chains.contains_key(&current_num) {
        path.push(current_num);
        current_num = square_digits(current_num);
    }

    let final_result = *chains.get(&current_num).unwrap();

    for &num_in_path in &path {
        chains.insert(num_in_path, final_result);
    }

    final_result
}

fn main() {
    let mut chains: HashMap<u32, u32> = HashMap::new();
    chains.insert(1, 1);
    chains.insert(89, 89);

    let mut count_89 = 0;
    for n in 1..=10_000_000 {
        if chain(n, &mut chains) == 89 {
            count_89 += 1;
        }
    }
    println!("{}", count_89);
}
