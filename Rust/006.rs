fn main() {
    let n: u32 = 100;
    let sum_of_squares: u32 = (1..=n).map(|x| x * x).sum();
    let sum_of_numbers: u32 = (1..=n).sum();
    let square_of_sum: u32 = sum_of_numbers * sum_of_numbers;

    println!("{}", square_of_sum - sum_of_squares);
}
