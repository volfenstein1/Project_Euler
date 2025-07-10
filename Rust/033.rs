fn gcd(a: u32, b: u32) -> u32 {
    if b == 0 {
        a
    } else {
        gcd(b, a % b)
    }
}

fn main() {
    let mut product_numerator = 1;
    let mut product_denominator = 1;

    for numerator in 10..100 {
        for denominator in (numerator + 1)..100 {
            let n_tens = numerator / 10;
            let n_units = numerator % 10;
            let d_tens = denominator / 10;
            let d_units = denominator % 10;

            // Check for the curious cancellation: units digit of numerator equals tens digit of denominator
            // Also ensure the cancelled digit is not zero (e.g., 30/50 is trivial)
            // And ensure the remaining denominator digit is not zero (to avoid division by zero)
            if n_units == d_tens && n_units != 0 && d_units != 0 {
                // Check if the original fraction value is equal to the cancelled fraction value
                // Using cross-multiplication to avoid floating-point inaccuracies
                if (numerator as u64 * d_units as u64) == (denominator as u64 * n_tens as u64) {
                    product_numerator *= numerator;
                    product_denominator *= denominator;
                }
            }
        }
    }

    let common_divisor = gcd(product_numerator, product_denominator);
    println!("{}", product_denominator / common_divisor);
}
