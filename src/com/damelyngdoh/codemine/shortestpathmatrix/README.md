# Two-Dimensional Shortest Path

There is a two-dimensional structure of cells where each cell has a certain value associated with it. Movement between the cells is restricted only to the right or lower cell, that is, you can only move to the right adjacent or lower adjacent cell. Moving from one cell to another comes at a cost where the cost of moving from cell A to cell B is calculated by the sum of the value in cell A and value in cell B.

You have to move from the top-left most cell to the right-bottom most cell. However since there are multiple paths, you have to find the path with the least cost incurred.

To display the shortest path, print the sequence of cells required to be traversed to reach the destination. Designate the cell by its coordinate.

## Input
1. The first line contains two positive integers `m` and `n` which represent the dimension of the structure (matrix).
2. There are `n` lines onf input after that and each line has `m` space separated numbers. Each number is a positive integer.

## Output
`(0,0)`

...

`(i,j)`

...

`(m,n)`

`i < m` and `j < n`

## Constraints
`0 < m, n`

`Array[i][j] > 0`

## Example
Input:

3 3

1, 2, 2

1, 1, 1

1, 2, 2

Output:

(0,0)
(1,0)
(1,1)
(1,2)
(2,2)

Explanation:
The first and last cells are obviously `(0,0)` and `(2,2)` respectively.
The shortest path has the cost of 6 which is from `(0,0)` with cost of `1`, `(1,0)` with cost of `1`, `(1,1)` with cost of `1` and `(1,2)` with cost of `1` and finally the last cell with cost of `2`.