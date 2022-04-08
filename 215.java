//heap can sort itself
//Max heap O(n + klogn)
//klogn = k*logn
//put all element to heap(loop  n time) then poll k times and logn is heapifying(sort the heap) the array

//Min heap O(nlogk)
//run through the array and add element to min heap in size k if greater than or equal to top element
//so the top one is the answer
//n is for running the array and logk is putting in k element 

//min heap
public int findKthLargest(int[] nums, int k){
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int num :nums){
        if(heap.size()<k || num >= heap.peek()){
            heap.offer(num)
        }
        if(heap.size()>k){
            heap.poll();
        }
    }
    return heap.peek();
}