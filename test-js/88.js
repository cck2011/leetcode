var merge = function(nums1, m, nums2, n) {
    while (n > 0) {
        if (m >= 0 && nums1[m - 1] > nums2[n - 1])
            nums1[m + n - 1] = nums1[--m]
        
        else nums1[m + n - 1] = nums2[--n]
    }
    return nums1
};
console.log(merge(nums1 = [1,2,3,0,0,0], m = 6, nums2 = [2,5,6], n = 3))



//put in nums1 then sort

//my solution
// var merge = function(nums1, m, nums2, n) {
//     for(i=0;i<=n-1;i++){
//         nums1[i+m] = nums2.pop()
//     }
    
//     nums1.sort(function(a,b){
//         return a-b;
//     })
//     console.log(nums1)
//     console.log(nums2)
// };
// console.log(merge(nums1 = [1,2,3,0,0,0], m = 6, nums2 = [2,5,6], n = 3))