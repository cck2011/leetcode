const nums = [2,3,5,9]
const target = 7

var twoSum = function(nums, target) {
    let res = [];
    let len = nums.length;
    console.log(len)
    for(let i = 0; i<len - 1;i++){
        console.log(nums[i])
        for(let j = i + 1;j < len;j++){
            if(nums[i] + nums[j] === target){
                res.push(i);
                res.push(j);
                console.log(i,j)
                return res;
            }
        }
    }
};

twoSum(nums,target)