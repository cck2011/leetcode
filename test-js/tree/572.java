public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    if (t1.val != t2.val) return false;
    return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
               //        out                     in
               //every layer have out in, extend every t1 and t2
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return kmp(serialize(root), serialize(subRoot));
    }
    boolean kmp(String s, String p) { // Check if s contains p?
        int[] lps = getLPS(p);
        int n = s.length(), m = p.length();
        for (int i = 0, j = 0; i < n; ++i) {
            //Return the i character of a string
            while (s.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == m) return true;
        }
        return false;
    }
    int[] getLPS(String p) {//Longest Prefix Suffix
        int m = p.length();
        int[] lps = new int[m];//m is the size of the array
        //init array is all 0
        for (int i = 1, j = 0; i < m; ++i) {//for loop the string
            while (p.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];//dont before the first char is equal,  -1 because index use 0
            //j = lps[j-1]; is used if j is repeat with the first  few words
            if (p.charAt(i) == p.charAt(j)) lps[i] = ++j;//
        }
        return lps;
    }
    //We know that characters pat[0..j-1](have j when only j++) match with txt[i-j…i-1].
    //lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
    ABCDABDABCA
    i = 4;
    lps[4] = 1;
    j=1;

    i=5;
    lps[5]=2;
    j=2;

    j=lps[1]//j is 2 in the moment
    j = 0
0,0,0,0,1,2,0
https://medium.com/@aakashjsr/preprocessing-algorithm-for-kmp-search-lps-array-algorithm-50e35b5bb3cb
//lps:
//The length of the longest proper prefix in the (sub)pattern that matches a proper suffix in the same (sub)pattern.
//
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);//refer to the next serialize function
        return sb.toString();
    }
    //method
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");
        } else {
            sb.append("," + root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
}