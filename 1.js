const nums = [2,3,5,9]
const target = 7

var twoSum = function(nums, target) {
    // Create a new map object
    const map = new Map()
    // Iterate through the numbers
    for(let i = 0; i<nums.length; i++){
        // calculate the complement of the target value
        const complement = target - nums[i]
        // if the complement is already found
        console.log('complement=',complement)
        if(complement in map){

            console.log('map[complement]=',map[complement])
            // return the index of the complement, and current index
            console.log('i=',i)
            console.log(map[complement],i)
            return [map[complement],i]
            
        }
        // else, add the number to the map
        
        map[nums[i]] = i
        
        console.log('map[nums[i]]=',map[nums[i]]);
        console.log('i=',i)
        console.log('map=',map);
        
    }
};
twoSum(nums,target)

