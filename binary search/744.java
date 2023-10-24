public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length;
    int l = 0, h = n - 1;
    while (l <= h) {
        int m = l + (h - l) / 2;
        if (letters[m] <= target) {//must return the next char after target
            l = m + 1;
        } else {
            h = m - 1;
        }
    }
    return l < n ? letters[l] : letters[0];// if target is the biggest letter, then l will be bigger than n
}

//dont know why cannot return l > n ? letters[0] : letters[l];
//error: java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4

// Input:
// letters = ["c", "f", "j"]
// target = "k"
// Output: "c"

// l = 2
// l = 3