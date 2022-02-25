/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class firstBadVersion extends VersionControl {
        public int firstBadVersion(int n) {
            int l = 0, r = n;
            while(l <= r){
                int mid = l + (r-l)/2;
                if(isBadVersion(mid))
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            if(isBadVersion(l))
                return l;
            return -1;
        }
    }