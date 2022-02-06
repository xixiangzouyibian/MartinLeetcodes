//
//
// English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 设计 数组 哈希表 数学 随机化 👍 18 👎 0

  
package com.martin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FortPu{

    //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> vals;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        vals = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        map.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int lastNum = vals.get(vals.size() - 1);
        vals.set(idx, lastNum);
        vals.remove(vals.size() - 1);
        map.put(lastNum, idx);
        map.remove(val);
        return true;

/*        Integer index = map.remove(val);
        if (index == null) {
            return false;
        }
        int lastNum = vals.get(vals.size()-1);
        vals.set(index, lastNum);
        vals.remove(vals.size()-1);
        map.put(lastNum, index);
        return true;*/
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(vals.size());
        return vals.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}