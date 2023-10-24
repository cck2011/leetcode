//bad question 
//only using the first world to compare with other word to get the difference
//if the first world have no prefix, then cannot find out

function longestCommonPrefix(strs) {
    if (!strs.length) return '';
    
    for (let i = 0; i < strs.length; i++) {  
        //flower fligt flasdf
      for (let str of strs) {
        console.log("strs[0][i]", strs[0][i])
        console.log("str[i]", str[i])
        if (str[i] !== strs[0][i]) {
            
          //flower fligt flasdf
          //flower
          return str.slice(0, i);
        }
      }
    }
    
    return strs[0];
  }

 

  var longestCommonPrefix2 = function(strs) {
    if (strs.length === 0) return '';
    let r = '';
    for (let i = 0; i < strs[0].length; i++) {
      for (let j = 1; j < strs.length; j++) {
        if (strs[0][i] !== strs[j][i]) return r;
      }
      r += strs[0][i];
    }
    return r;
  };
console.log(longestCommonPrefix2(["tog","docecar","dotar"])) 