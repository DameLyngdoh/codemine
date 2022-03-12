# Island Count

There is a rectangular empty map with squares and there are islands shown in the map. Each square can represent empty space or land called a tile. A set tiles where each tile is adjacent to at least one other tile in the set is called an *island*. A tile has four adjacent tiles, the tile above it, below it, to its immediate left or right. The size of an island is the number of tiles that compose that island.

Find the number of islands in the map and also the size of the largest island.

## Input
1. The first line contains two positive integers `m` and `n` which represent the length and breadth of the map.
2. There are `n` lines onf input after that and each line has `m` space separated numbers. Each number is either `0` which represent an empty square or `1` which represent a tile.

## Output
`
Number of islands: A
Largest island has B tiles.
`
where `A` is the number of islands in the map and `B` is the size of the largest island.

Or if no island are found in the map then the output should be:
`
No islands were found.
`

## Constraints
`0 < m, n`

`Array[i][j] = 1 or Array[i][j] = 0 for 0 ≤ i < m and 0 ≤ j < n`

## Example
Input:

5 5

1 0 0 0 1

1 1 0 0 1

0 0 1 0 0

0 0 0 0 0

0 0 0 0 1

Output:

Number of islands: 4
Largest island has 3 tiles.

Explanation:
The islands are `{(0,0), (1,0), (1,1)}`, `{(0,4), (1,4)}`, `{(2,2)}` and `{(4,4)}`.
The largest island is `{(0,0), (1,0), (1,1)}` since it has `3` tiles.