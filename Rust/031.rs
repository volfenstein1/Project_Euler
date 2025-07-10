fn main() {
    let coins = [1, 2, 5, 10, 20, 50, 100, 200];
    let mut total_ways = vec![0; 201];
    total_ways[0] = 1;

    for &coin in coins.iter() {
        for i in coin..=200 {
            total_ways[i as usize] += total_ways[(i - coin) as usize];
        }
    }

    println!("{}", total_ways[200]);
}
