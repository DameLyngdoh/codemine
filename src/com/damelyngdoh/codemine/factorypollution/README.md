# Factory Pollution

A company has numerous factories operating and each factory produces a specific amount of pollution specified by a positive integer. The company receives word that the government has now mandated that each company produce half the net amount of pollution it currently produces. The net amount of pollution generated by a company is the sum of pollution generated by all the factories belonging to the company. In order to do so, filters have to used and each filter reduces the pollution emitted by a factory by half. In order to reduce the expenditure on the filters to be used, the company decides to use the minimum number of filters such that the maximum amount of pollution it generates is less than or equal half of the current net pollution generated.

A factory can be fitted with more than one filter and each filter reduces the pollution generated by half. So if two filters are used on a factory, the pollution generated by the factory is reduced by a factor of `4`.

Given a series of positive integers which indicate the pollution generated by each factory, find the minimum number of filters that the company should use so as to meet the goverment requirements.

## Input
1. The first line is a positive integer which indicates the number of factories, `n`.
2. The second line contains `n` space separated positive integers which indicates the pollution generated by a factory.

## Output
`
N
`
where `N` is the minimum required number of filters to be used.

## Constraints
`0 < n`

`0 < A[i], i = 0, 1,..., n-1`

## Example
Input:

5

10 2 1 1 1

Output:

2

Explanation:

The total pollution generated is `15` and the maximum required level is half of that which is `7.5`.
Adding a filter to the first factory reduces the pollution of first factory to `5` and total pollution reduces to `10`.
Adding another filter to the first factory further reduces its pollution generation to `2.5` and the total pollution reduces to `7.5` which meets the required maximum.

So hence the minimum required number of filters is `2`.