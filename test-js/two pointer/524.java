public String findLongestWord(String s, List<String> d) {
    String longestWord = "";
    for (String target : d) {
        int l1 = longestWord.length(), l2 = target.length();
        if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) { //return  negative integer  if target is exicographically less than the other string  if l1 and l2 kength is the same then check is longestWord 
            continue;
        }
        if (isSubstr(s, target)) {
            longestWord = target;
        }
    }
    return longestWord;
}

private boolean isSubstr(String s, String target) {
    int i = 0, j = 0;
    while (i < s.length() && j < target.length()) {//y cannot only i < s.length()
        if (s.charAt(i) == target.charAt(j)) {
            j++;
        }
        i++;
    }
    return j == target.length();
}
//my ugly first solution
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int dictLength = dictionary.length - 1;//int dictLength = dictionary.size() - 1; it is list
        String LongestWord = null;
        int i = 0;
        while(dictLength-->=0){
            String word = dictionary[i];//String word = dictionary.get(i); it is list
            int l1 = word.length();
            int l2 = LongestWord.length();
            if(l2>l1 || (l1 == l2 && LongestWord.compareTo(word)<0)){//l1>l2
                boolean result = matchString(word);
                if(result){
                    LongestWord = word;
                }
            }
            //i++ missing
            
        }
        return LongestWord;
    }

    public Boolean matchString(String s, String Word) {
        int i = 0;
        int y = 0;
        int sLengths = s.length();//int sLengths = s.length()-1;
        int WordLength = Word.length();
        while(sLengths-->=0){
            if(s.charAt(i) == Word.charAt(y)){
                i++;
                y++;
            }else{
                i++;
            }
            if(y == WordLength){
                return true;
            }
            
        }
        return false;
    }
}
//After correction, can run
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int dictLength = dictionary.size() - 1;
        String LongestWord = "";
        int i = 0;
        while(dictLength-->=0){
            String word = dictionary.get(i);
            int l1 = word.length();
            int l2 = LongestWord.length();
            if(l1>l2 || (l1 == l2 && LongestWord.compareTo(word)>0)){
                boolean result = matchString(s,word);
                if(result){
                    LongestWord = word;
                }
            }
            i++;
            
        }
        return LongestWord;
    }

    public Boolean matchString(String s, String Word) {
        int i = 0;
        int y = 0;
        int sLengths = s.length()-1;
        int WordLength = Word.length();
        while(sLengths-->=0){
            if(s.charAt(i) == Word.charAt(y)){//y should ne out of range, need i < s.length() && j < target.length()
                i++;
                y++;
            }else{
                i++;
            }
            if(y == WordLength){
                return true;
            }
            
        }
        return false;
    }
}

// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]

// Output:
// "apple"


class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for(String target : dictionary){
            int l1 = target.length(), l2 = longestWord.length();
            if(l1>l1 ||(l1 == l2 && longestWord.compareTo(target)<0)){
                if(matchString(s,target)){
                    longestWord = target;
                }
            }

        }
        return longestWord
    }
    
    public Boolean matchString(String s, String target){
        int i = 0;
        int y = 0;
        while(i < s.length() && j < target.length()){//stop looping after finding all char in target
            if(s.charAt(i) == target.charAt(y)){
                y++;
            }
            i++;
        }
        return target.length() == y;
    }

}