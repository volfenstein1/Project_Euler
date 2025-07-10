fn main() {
    let fizz_buzz_sum: u32 = (0..1000).filter(|x| x % 3 == 0 || x % 5 == 0).sum();
    println!("{}", fizz_buzz_sum);
}
