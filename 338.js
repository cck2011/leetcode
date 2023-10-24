
// how many 1
let countBits = N => {
    let ans = [ 0 ];
    for (let i = 1; i <= N; i++)
    // console.log(1 >> 1)
    // console.log(2 >> 1)
    // console.log(3 >> 1)
    // console.log(4 >> 1)
    // console.log(5 >> 1)
    
        ans.push(ans[i >> 1] + (i & 1))
        
        
    return ans;
};

https://www.youtube.com/watch?v=OfIyDdepVL0&t=3s
// console.log(countBits(7));
// 011212
//d
01
10
11
100
10101
var countBits2 = function(num) {
    const result = [0];
      for (let i = 1; i <= num; i++) {
         if(i%2==0){
             console.log(i)
             result[i]= result[Math.floor(i/2)]
             
         }else{
            console.log(i)
             result[i]=result[Math.floor(i/2)]+1 
          }
      }
      return result;
  };

  console.log(countBits2(7));