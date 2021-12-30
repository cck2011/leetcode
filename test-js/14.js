function longestCommonPrefix(strs) {
    if (!strs.length) return '';
    
    for (let i = 0; i < strs[0].length; i++) {
        console.log(strs[0].length)
      for (let str of strs) {
          
        if (str[i] !== strs[0][i]) {
          return str.slice(0, i);
        }
      }
    }
    
    return strs[0];
  }

 console.log(longestCommonPrefix(["flower","flow","flight"])) 