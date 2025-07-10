use std::collections::HashSet;

fn is_pandigital(s: &str) -> bool {
    if s.len() != 9 {
        return false;
    }
    let mut chars: Vec<char> = s.chars().collect();
    chars.sort_unstable();
    chars.into_iter().collect::<String>() == "123456789"
}

fn main() {
    let mut pandigital_products: HashSet<u32> = HashSet::new();

    // Iterate through possible multiplicands 'a'
    // Based on digit count analysis (1-digit * 4-digit = 4-digit or 2-digit * 3-digit = 4-digit)
    // 'a' can range from 1 to 99.
    for a in 1..100 {
        // Iterate through possible multipliers 'b'
        // Start 'b' from 'a + 1' to avoid duplicate pairs (e.g., 2*3 vs 3*2) and ensure a < b.
        // The upper bound for 'b' is determined by the maximum possible product (9999)
        // and the smallest 'a' (1), so b can go up to 9999.
        for b in (a + 1)..10000 {
            let product = a * b;
            let s = format!("{}{}{}", a, b, product);

            // If the concatenated string is already longer than 9 digits,
            // then increasing 'b' further will only make it longer.
            // So, break the inner loop and try the next 'a'.
            if s.len() > 9 {
                break;
            }

            // If the concatenated string has exactly 9 digits, check if it's pandigital.
            if s.len() == 9 && is_pandigital(&s) {
                pandigital_products.insert(product);
            }
        }
    }

    let total_sum: u32 = pandigital_products.iter().sum();
    println!("{}", total_sum);
}
