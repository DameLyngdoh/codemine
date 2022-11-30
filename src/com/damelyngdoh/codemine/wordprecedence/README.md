# Word Precedence

You are given a set of predicates of the form `A>X` which means that the character `A` immediately preceeds the character `X` in a string. These set of predicates when arranged accordingly will form a string. Your task is to determine the string when given these set of predicates.

## Input
1. The first line is a positive integer which indicates the number of predicates, `n`.
2. The next `n` lines contain a predicate of the form `A>X` where `A` and `X` represent uppercase English alphabets.

## Output
The string which is obtained.

## Constraints
Any two predicates in the set, `A>B` and `X>Y`, `A ≠ X` and `B ≠ Y`.

## Example
Input:

4

P>A

A>I

S>P

I>N

Output:

SPAIN

Explanation:

In the set of predicates, `P` immediately preceeds `A`, which is the case in the string `SPAIN`. The same goes for the rest of the other predicates.