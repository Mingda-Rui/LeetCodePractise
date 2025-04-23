package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0271EncodeAndDecodeStrings {}

class LC0271Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            String encodedStr = str.replace("#", "##");
            sb.append(encodedStr).append("@#@");
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> result = new LinkedList<>();
        String[] strs = s.split("@#@", -1);

        for (String str : strs) {
            String decodedStr = str.replace("##", "#");
            result.add(decodedStr);
        }

        result.remove(result.size() - 1);
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
