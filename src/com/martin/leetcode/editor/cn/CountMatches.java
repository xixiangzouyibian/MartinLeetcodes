package com.martin.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Martin Zhou on 2021/2/28
 */
public class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);

        int count = 0;
        int checkIndex = map.get(ruleKey);
        for (List<String> item : items) {
            if (item.get(checkIndex).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
