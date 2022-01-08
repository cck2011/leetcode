
//save the next element and compare it in the next for loop
var isValid = function(s) {
    if (s.replace(/[\(\)\{\}\[\]]/g,"") !== "") {
        return false; // invalid string
    }
    let stack = [];
    for (let i = 0; i < s.length; i++) {
    //    console.log(stack)
        if (s[i] === "(") {
            stack.push(")");
        } else if (s[i] === "[") {
            stack.push("]");
        } else if (s[i] === "{") {
            stack.push("}");   
        } else { // encountered a closing bracket
            if (s[i] !== stack.pop()) {
                return false;
            }
        }
        console.log(stack)
    }
    return stack.length === 0;
    // T.C: O(N)
    // S.C: O(N)
};
console.log(isValid('({})'))
//)}
var isValid2 = function(s) {   
    const stack = [];
   
    const map = {
      '(': ')',
      '[': ']',
      '{': '}'
    }
    
    for (let i = 0 ; i < s.length ; i++) {
        let c = s[i];
        // stack ),],}
          
        if (map[s[i]]) {
            //if open bracket then push ),],}
          stack.push(map[s[i]])
          console.log(stack)
          
        } else if (s[i] !== stack.pop()) {
            //if close bracket
            //should be equal s[i] us close bracket
          return false;
        } 
    }
    
    return !stack.length;
};
// console.log(isValid2('()[]{}'))