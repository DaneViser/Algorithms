package leet_code_75;

import java.util.*;


public class Solution {
    // Running sum of 1d Array
    static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
    // Find Pivot Index
    static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftsum = 0;
        for (int ele : nums)
            totalSum += ele;

        for (int i = 0; i < nums.length; leftsum += nums[i++])
            if (leftsum * 2 == totalSum - nums[i])
                return i;
        return -1;
    }
    // Isomorphic Strings
    static boolean isIsomorphic(String s, String t) {
        Map<java.io.Serializable, Integer> m = new HashMap<java.io.Serializable, Integer>();
        for (Integer i = 0; i < s.length(); ++i)
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i) + "", i)) return false;
        return true;
    }

    // Is Subsequence
    static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    // Merge Two Sorted Lists
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // to add remaining of the two lists
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }

        return dummy.next;
    }
    // Reverse Linked List
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    // Middle of the Linked List
    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Linked List Cycle 2
    static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    // Best Time to Buy and Sell Stock
    static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;
    }
    // Longest Palindrome
    static int longestPalindrome(String s) {
        int[] count = new int[256];
        int odds = 0;
        for (int v = 0; v < s.length(); v++) {
            char currChar = s.charAt(v);
            count[currChar] += 1;
            odds += (count[currChar] & 1) == 1 ? 1 : -1;
        }
        return s.length() - odds + (odds > 0 ? 1 : 0);
    }
    // N-ary Tree Preorder Traversal
    static List<Integer> preorder(Node root) {
        List<Integer> output = new ArrayList<Integer>();
        Stack<Node> st = new Stack<>();

        if (root == null) return output;

        st.push(root);
        while (!st.isEmpty()) {
            Node node = st.pop();
            output.add(node.val);

            for (int idx = node.children.size() - 1; idx >= 0; idx--) {
                Node child = node.children.get(idx);
                st.push(child);
            }
        }
        return output;
    }
    // Binary Tree Level Order Traversal
    static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < nodeNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
    // Binary Search
    static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else if (nums[start] == target) {
                return start;
            } else if (nums[end] == target) {
                return end;
            } else {
                return mid;
            }
        }
        return -1;
    }
    // First Bad Version
    static boolean isBadVersion(int n) {
        for (int i = 0; i <= n; i++) {
            if (i == n) return true;
        }
        return false;
    }

    static int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    // Validate Binary Search Tree
    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>();
        queue.add(new Pair<>(sr, sc));

        int startColor = image[sr][sc];
        if (startColor == color) return image;
        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.peek();
            int r = cell.getFirst();
            int c = cell.getSecond();
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int adjx = r + dRow[i];
                int adjy = c + dCol[i];
                // Check for in bounds and start color
                // NOTE: We don't need visited list, since we check if the color is equal to the starting color. If its not then its visited already.
                if (adjx >= 0 && adjy >= 0 && adjx < image.length && adjy < image[0].length && image[adjx][adjy] == startColor) {
                    image[adjx][adjy] = color;
                    queue.add(new Pair<>(adjx, adjy));
                }
            }

        }
        return image;
    }
    // Number of Islands
    private static boolean explore(char[][] grid, int row, int col, Set<Pair<Integer, Integer>> visited) {
        Pair<Integer, Integer> pos = new Pair<>(row, col);

        boolean rowInBounds = 0 <= row && row < grid.length;
        boolean colInBounds = 0 <= col && col < grid[0].length;
        if (!rowInBounds || !colInBounds) return false;
        if (grid[row][col] == '0') return false;
        if (visited.contains(pos)) return false;
        visited.add(pos);

        explore(grid, row - 1, col, visited);
        explore(grid, row + 1, col, visited);
        explore(grid, row, col - 1, visited);
        explore(grid, row, col + 1, visited);

        return true;
    }

    public int numIslands(char[][] grid) {

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (explore(grid, i, j, visited)) {
                    count++;
                }
            }
        }

        return count;
    }
    // Fibonacci Number
    // I added memo for speed !
    static Map<Long, Long> hmap = new HashMap<>();
    static Long j = 1L;

    static Long fib(long n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        if (hmap.containsKey(n)) return hmap.get(n);

        Long res = fib(n - 1) + fib(n - 2);
        hmap.put(n, res);
        return res;

    }


    public static void main(String[] args) {
        // Check from laptop
        System.out.println(fib(13L));
    }
}


