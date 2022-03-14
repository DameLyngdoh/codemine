# String Trimmer

Given a string of words comprising of uppercase and lowercase English alphabets and space, the string is to be trimmed such that it has at most `k` characters in the trimmed string. However the string should be trimmed in such a way that the last word is partial. A word is a consecutive sequence of letters (uppercase and lowercase). For example, the string `Hello World` trimmed to have at most `8` characters will produce the output `Hello` and not `Hello Wo` as `Wo` is a partial form of `World`.

## Input
1. The first line contains a string terminated by the carriage return.
2. The second line contains a non-negative integer `k`.

## Output

Trimmed string.

## Constraints
1. String input does not start or end with a space.
2. String input does not contain two or more consecutive spaces.
3. `0 ≤ k`.

## Example
Input:
```sh
Hello World I am a teapot

15
```
Output:
```sh
Hello World I
```