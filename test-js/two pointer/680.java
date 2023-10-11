//my solution
class Solution {
    public boolean validPalindrome(String s) {
        //check isPalindrome after deleting one character
        int l = 0;
        int h = s.length() -1;
        
        while(l<=h){
            char lowerChar = s.charAt(l);
            char higherChar = s.charAt(h);

            if(lowerChar != higherChar){
                return (isPalindrome(s,l+1,h)||isPalindrome(s,l,h-1));
            }

            l++;
            h--;
        }
        return true;

    }

    public boolean isPalindrome(String s, int l, int h) {//need a function that can check if palindrome in whatever starting and ending point because the element that need to be deleted could be in any position


        while(l<=h){
            char lowerChar = s.charAt(l);
            char higherChar = s.charAt(h);

            if(lowerChar == higherChar){
                l++;
                h--;
            }else{
                return false;
            }
        }
        return true;


    }
}