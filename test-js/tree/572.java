public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);//run once in the root first
    //then run is SubtreeWithRoot in all left and right node
}

private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
    if (t == null && s == null) return true;//both node are null, empty is also regard as equal
    if (t == null || s == null) return false;
    if (t.val != s.val) return false;
    return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
}

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return kmp(serialize(root), serialize(subRoot));
    }
    //the use of lps is to skip
    //lps:AAX
    //    010
    //s:AAAAAX
    //  122223
    //return true becuase j=3
    boolean kmp(String s, String p) { // Check if s contains p?
        int[] lps = getLPS(p);
        int n = s.length(), m = p.length();
        for (int i = 0, j = 0; i < n; ++i) {
            //Return the i character of a string
            while (s.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];//eg if j fail to match in the 3 words, then it can start from the second one ,as it already know 
            if (s.charAt(i) == p.charAt(j)) j++;
            if (j == m) return true;//if j(subroot index) = subroot length then true
        }
        return false;
    }
    //j is prefix and j = lps[j-1] is suffix
    int[] getLPS(String p) {//Longest Prefix Suffix
        int m = p.length();
        int[] lps = new int[m];//m is the size of the array
        //init array is all 0
        for (int i = 1, j = 0; i < m; ++i) {//for loop the string
            while (p.charAt(i) != p.charAt(j) && j > 0) j = lps[j-1];//dont before the first char is equal,  -1 because index use 0
            //j = lps[j-1]; if p.charAt(i) != p.charAt(j) then check if the previous index is the same until j is 0.(j represent the prefix))
            //check previous index beacuse if match then no need to start from the begining 
            if (p.charAt(i) == p.charAt(j)) lps[i] = ++j;//
        }
        return lps;
    }
    //We know that characters pat[0..j-1](have j when only j++) match with txt[i-j…i-1].
    //lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
    ABCDABD
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
https://iq.opengenus.org/prefix-table-lps/
http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
//lps:
//The length of the longest proper prefix in the (sub)pattern that matches a proper suffix in the same (sub)pattern.
//
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);//refer to the next serialize function
        return sb.toString();
    }
    //void function excute a task and do not return a function
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#");//means return, but why?
        } else {
            sb.append("," + root.val);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }
    //must use preorder and postorder because inorder always start with null and end with null 
    //which is different from preorder and postofer that is only reversed.
//     Inorder => Left, Root, Right.

// Preorder => Root, Left, Right.

// Post order => Left, Right, Root.
}
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String s1 = convertTree(s);
        String s2 = convertTree(t);
        return s1.contains(s2);
    }
    
    protected String convertTree(TreeNode root) {
        if(root == null) {
            return "";
        }
        String s = "" + root.val;
        s = "[" + s.length() + "]" + s;
        String left = convertTree(root.left);
        String right = convertTree(root.right);
        if(left.length() != 0) {
            left = "l" + left;
        }
        if(right.length() != 0) {
            right = "r" + right;
        }
        return s + "(" + left + right + ")";
    }
}
