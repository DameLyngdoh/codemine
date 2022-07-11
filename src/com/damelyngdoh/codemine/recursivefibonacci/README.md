# Optimized Recursive Fibonacci

You are given an array of positive numbers. Complete two task:

1. Write a recursive function to determine if a positive integer is a term in the Fibonacci Series or not. The method must return `true` or `false` accordingly.

2. Using the above function to determine if each element of the array is a term in the Fibonacci Series or not.

You may optimize the solution by using persisting intermediate results if necessary.

## Input
1. The first line is a positive integer which indicates the number of elements in the array, `n`.
2. The second line contains `n` space separated positive integers.

## Output
`
A[0] -> true/false
A[1] -> true/false
.
.
.
A[n-1] -> true/false
`

## Constraints
`0 < n`

`0 < A[i], i = 0, 1,..., n-1`

## Example
Input:

5

1 3 5 4 6

Output:

1 -> true

3 -> true

5 -> true

4 -> false

6 -> false
