# LeetCodePractise

My LeetCode Practise

# Leetcode problem naming scheme

`[A-Z]{3}\d{4}(ProblemName)`<br>
e.g.<br>
`AAD0003LengthOfLongestSubstring`<br>
`AAH0007ReverseInteger`<br>
`ADN0091DecodeWays`

# Use NamingHelper

In Github UI, classes in the same package are sorted by class name initials.
If we want the leetcode problem sorted in the same order with their problem number,
we need to covert the problem number to string,
and make sure github orders those string in the same way with the problem number's order.

`NamingHelper` helps to convert the problem number to a prefix, so that we can prefix each class name with the prefix,
and those classes will be ordered in UI in the same way with their problem number.
It can also convert the prefix back to problem number.

```shell script
./script/util/NamingHelper ${one or more prefix_in_lettes/number_of_leetcode_problem}
# e.g ./script/util/NamingHelper AAA 123 ACD 432 444
```
