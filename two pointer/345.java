private final static HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

public String reverseVowels(String s) {
    if (s == null) return null;
    int i = 0, j = s.length() - 1;
    char[] result = new char[s.length()];
    while (i <= j) {
        char ci = s.charAt(i);
        char cj = s.charAt(j);
        if (!vowels.contains(ci)) {
            result[i++] = ci;
        } else if (!vowels.contains(cj)) {
            result[j--] = cj;
        } else {
            result[i++] = cj;
            result[j--] = ci;
        }
    }
    return new String(result);
}

class Solution {
private static final HashSet<Character> vowels = new HashSet<>(
        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
public String reverseVowels(String s) {
    if (s == null) return null;
    int l = 0;
    int h = s.length() -1;
    char[] result = new char[s.length()];
    while(l<=h){
        char lowerChar = s.charAt(l);
        char higherChar = s.charAt(h);
        
        if(vowels.contains(lowerChar) && vowels.contains(higherChar)){//both contain vowels
            result[l++] = higherChar;//exchan
            result[h--] = lowerChar;
        }else if(!vowels.contains(lowerChar)){//lower not contain vowels
            result[l++] = lowerChar;
        }else{
            result[h--] = higherChar;
        }
    }
    return new String(result);
}
}

private static final Hashset<> vowels = new Hashset<>(Array.asList());