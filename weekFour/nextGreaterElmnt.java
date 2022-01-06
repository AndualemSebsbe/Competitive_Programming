import java.util.HashMap;
import java.util.Stack;

class nextGreaterElmnt {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
      
        Stack<Integer> st = new Stack<>();
        int res[] = new int[nums1.length];
        int count = 1;
        st.push(nums2[0]);
        for(int num: nums2){
            while((!st.empty()) && (st.peek() < num))
            {
                //int val = st.pop();
                map.put(st.pop(), num);              
            }  
           st.push(num);
        }
        
        for(int i=0; i< nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}