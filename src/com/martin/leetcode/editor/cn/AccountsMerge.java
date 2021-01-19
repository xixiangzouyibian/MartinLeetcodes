//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//输出：
//[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
//["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 
//
// 提示： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 203 👎 0


package com.martin.leetcode.editor.cn;


import java.util.*;

public class AccountsMerge{
    public static void main(String[] args) {
       Solution solution = new AccountsMerge().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        UnionFind unionFind = new UnionFind(len);

        Map<String, Integer> mail2acc = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                String mail = acc.get(j);
                if (mail2acc.containsKey(mail)) {
                    unionFind.union(mail2acc.get(mail), i);
                } else {
                    mail2acc.put(mail, i);
                }
            }
        }

        Map<Integer, List<String>> account2Mail = new HashMap<>();
        for (String mail : mail2acc.keySet()) {
            int accId = mail2acc.get(mail);
            account2Mail.computeIfAbsent(unionFind.find(accId), k -> new ArrayList<>()).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int accId : account2Mail.keySet()) {
            List<String> mails = account2Mail.get(accId);
            Collections.sort(mails);
            mails.add(0, accounts.get(accId).get(0));
            ans.add(mails);
        }
        return ans;
    }

    class UnionFind {
        int[] p;
        public UnionFind(int len) {
            p = new int[len];
            for (int i = 0; i < len; i++) {
                p[i] = i;
            }
        }

        public int find(int id) {
            if (p[id] != id) {
                p[id] = find(p[id]);
            }
            return p[id];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                p[xRoot] = yRoot;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
