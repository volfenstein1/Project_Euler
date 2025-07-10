use std::collections::HashSet;

const K_MAX: usize = 12000;
// An upper bound for N to search up to. For K_MAX = 12000, N is typically not much larger than 2*K_MAX.
const MAX_N_SEARCH: usize = 2 * K_MAX + 100; // Added a small buffer

// Using a static mutable array to store minimal product-sum numbers for each k.
// This requires `unsafe` blocks for access.
static mut MINIMAL_PRODUCT_SUMS: [usize; K_MAX + 1] = [0; K_MAX + 1];

fn search(product: usize, sum: usize, num_factors: usize, start_factor: usize) {
    // Calculate k for the current product and sum.
    // k = (product - sum) + num_factors
    // This formula accounts for the '1's needed to make the sum equal to the product.
    let k_val = product - sum + num_factors;

    // If k_val is within our target range, update the minimal product-sum for this k.
    if k_val <= K_MAX {
        unsafe {
            if product < MINIMAL_PRODUCT_SUMS[k_val] {
                MINIMAL_PRODUCT_SUMS[k_val] = product;
            }
        }
    }

    // Pruning conditions:
    // 1. If the product is already too large, no need to continue this branch.
    if product >= MAX_N_SEARCH {
        return;
    }

    // Iterate through possible next factors.
    // The factor must be at least `start_factor` to avoid redundant calculations
    // and ensure factors are non-decreasing.
    // The factor must also be such that `product * factor` does not exceed `MAX_N_SEARCH`
    // and `k_val` does not exceed `K_MAX` too early.
    for factor in start_factor.. {
        let new_product = product * factor;
        let new_sum = sum + factor;
        let new_num_factors = num_factors + 1;

        // Calculate the potential k_val for the next step.
        let potential_k_val = new_product - new_sum + new_num_factors;

        // Pruning: If the potential k_val exceeds K_MAX, or if the new product exceeds MAX_N_SEARCH,
        // then this branch will not yield a valid result within our limits.
        if potential_k_val > K_MAX || new_product > MAX_N_SEARCH {
            break; // Stop iterating factors for this branch
        }

        // Recursive call with the new product, sum, factor count, and starting factor.
        search(new_product, new_sum, new_num_factors, factor);
    }
}

fn main() {
    // Initialize minimal_product_sums with a value larger than any possible N.
    // This ensures that the first valid product-sum found for each k will be stored.
    unsafe {
        for i in 0..=K_MAX {
            MINIMAL_PRODUCT_SUMS[i] = MAX_N_SEARCH; // Initialize with a value larger than any possible N
        }
    }

    // Start the search.
    // Initial call: product = 1, sum = 0, num_factors = 0, min_factor = 2.
    // This means we are building the product and sum using factors >= 2.
    // The '1's needed to satisfy the sum condition are implicitly handled by the `k_val` calculation.
    search(1, 0, 0, 2);

    // Collect unique minimal product-sum numbers for k from 2 to K_MAX.
    let mut unique_minimal_product_sums: HashSet<usize> = HashSet::new();
    unsafe {
        for i in 2..=K_MAX {
            // Only add if a valid minimal product-sum was found for this k.
            if MINIMAL_PRODUCT_SUMS[i] != MAX_N_SEARCH {
                unique_minimal_product_sums.insert(MINIMAL_PRODUCT_SUMS[i]);
            }
        }
    }

    // Sum all the unique minimal product-sum numbers.
    let total_sum: usize = unique_minimal_product_sums.iter().sum();
    println!("{}", total_sum);
}
