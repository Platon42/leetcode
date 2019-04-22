package binarysearch;

public class FirstBadVersion extends VersionControl{

    public int firstBadVersion(int n) {

           int left = 1, right = n;
            while(left < right) {
                // Prevent (left + right) overflow
                int mid = left + (right - left) / 2;
                //System.out.println(mid);
                if(isBadVersion(mid)){
                    System.out.println(mid);
                    right=mid;
                }
                else if (!isBadVersion(mid)) {
                    System.out.println(mid);
                    left = mid + 1;
                    right = n;
                }
            }

            // Post-processing:
            // End Condition: left == right
            if (left != n && isBadVersion(left)) return left;
            if (left ==1 && right==1) return 1;
            return -1;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(6));
    }
}
