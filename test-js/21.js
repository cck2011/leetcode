
https://ithelp.ithome.com.tw/articles/10246209
var mergeTwoLists = function(l1, l2) {
    var mergedHead = 
    { 
    val : -1,
    next : null
    },
        crt = mergedHead;
        
    while(l1 && l2) {
        
        if(l1.val > l2.val) {
        
            
            crt.next = l2;
            l2 = l2.next;
        } else {
            crt.next = l1;
            l1 = l1.next;
        }
        crt = crt.next;
    }
    crt.next = l1 || l2;
    
    return mergedHead.next;
};
let list1 = [1,1,4]
let list2 = [1,3,4]
console.log(mergeTwoLists(list1,list2))



var mergeTwoLists = function(l1, l2) {
    if (!l1) return l2;
    if (!l2) return l1;
    if (l1.val < l2.val) {
        //should point from l1 cuz l1 is smaller
        l1.next = mergeTwoLists(l1.next, l2);
        //point from where
        return l1;
        //point to where
    }
    l2.next = mergeTwoLists(l2.next, l1);
    return l2;
};

//https://www.youtube.com/watch?v=bdWOmYL5d1g