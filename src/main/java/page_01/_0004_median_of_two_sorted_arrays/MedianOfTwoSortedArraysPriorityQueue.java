package page_01._0004_median_of_two_sorted_arrays;

import java.util.PriorityQueue;
import java.util.Vector;

public class MedianOfTwoSortedArraysPriorityQueue {
    // Using Priority Queue
    // Time: O(max(N, M)*log(max(N, M)))
    // Space: O(N+M)

    public double findMedianSortedArrays(Vector<Integer> A, Vector<Integer> B) {
        int i;
        int n = A.size();
        int m = B.size();
        // initializing Priority Queue (Min Heap)
        PriorityQueue<Integer> pq
                = new PriorityQueue<Integer>();
        // pushing array A values to priority Queue
        for (i = 0; i < n; i++) {
            pq.add(A.get(i));
        }
        // pushing array B values to priority Queue
        for (i = 0; i < m; i++) {
            pq.add(B.get(i));
        }
        int check = n + m;
        double count = -1;
        double mid1 = -1, mid2 = -1;
        while (!pq.isEmpty()) {
            count++;
            // returning mid value if combined length(n+m)
            // is odd
            if (check % 2 != 0 && count == check / 2) {
                double ans = pq.peek();
                return ans;
            }
            // maintaining mid1 value if combined
            // length(n+m) is even where we need to maintain
            // both mid values in case of even combined
            // length
            if (check % 2 == 0
                    && count == (check / 2) - 1) {
                mid1 = pq.peek();
            }
            // now returning the mid2 value with previous
            // maintained mid1 value by 2
            if (check % 2 == 0 && count == check / 2) {
                mid2 = pq.peek();
                double ans = (mid1 + mid2) / 2;
                return ans;
            }
            pq.poll();
        }
        return 0.00000;
    }
}
