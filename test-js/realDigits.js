let x = 23935198273
let sum =0;
let sum2 = 0
let digits = x.toString().split('');
// console.log(digits);
let realDigits = digits.map(Number)
console.log(realDigits);
for (let i = 0; i < realDigits.length; i++){
    
    sum += realDigits[i]
    console.log(sum);
   

}