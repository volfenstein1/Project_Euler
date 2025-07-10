use std::fs;

fn name_score(name: &str) -> u32 {
    name.chars().map(|c| (c as u32) - ('A' as u32) + 1).sum()
}

fn main() {
    let content = fs::read_to_string("names.txt").expect("Unable to read file");
    let mut names: Vec<String> = content
        .trim()
        .replace('"', "")
        .split(',')
        .map(|s| s.to_string())
        .collect();

    names.sort();

    let mut total_score: u64 = 0;
    for (i, name) in names.iter().enumerate() {
        total_score += ((i + 1) as u64) * (name_score(name) as u64);
    }

    println!("{}", total_score);
}
