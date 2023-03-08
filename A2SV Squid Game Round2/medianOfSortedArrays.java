import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class medianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list =new ArrayList<>();
        double e=0;
        double f=0;
        double h=0;
        for(int num: nums1){
            list.add(num);
        }
        for(int num: nums2){
            list.add(num);
        }

        Collections.sort(list);
        int size = list.size();
        int mid = size/2;
        if(size%2 != 0){
           e = list.get(mid);
           return e; 
        }
        else{
            e=list.get(mid);
            f=list.get(mid-1);
            h=((e+f)/2);
            return (double)h;
        }  
    }
}