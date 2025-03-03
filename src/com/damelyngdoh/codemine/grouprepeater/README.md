# Group Repeater

Given a string and you are required to process the string to obtain a result. The character set contains lower case alphabets, a positive integer, a `[` and `]`.  The string contains two types of sub-sequences:
- a sub-sequence of lowercase alphabets, which are not altered
- or a sub-sequence with the pattern `n[<sub-sequence>]`, where `n` is a positive integer and `<sub-sequence>` is another valid sub-sequence. This means that the inner `<sub-sequence>` must be repeated `n` times. For example: `2[abc]` after processing will result to `abcabc`.

A sample input string `2[ab3[d]]xyz3[rr]` will generate the output `abdddabdddxyzrrrrrr`. An empty input string will result to an empty result string.

Examples:
1. `1[a]2[b]c` = `abbc`
2. `abcdef` = `abcdef`
3. `2[a2[er]2[t]w]` = `aererttwaererttw`
