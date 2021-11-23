import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 4 };
		int arr2[] = { 1, 3, 4 };
		ListNode l1 = getLL(arr1);
		ListNode l2 = getLL(arr2);
		ListNode resNode = merge(l1, l2);
		printLL(resNode);
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
		
		return l2;
	}

	public static ListNode getLL(int arr1[]) {
		ListNode l1 = new ListNode(0);
		ListNode temp1 = l1;
		for (int i = 0; i < arr1.length; i++) {
			temp1.next = new ListNode(arr1[i]);
			temp1 = temp1.next;
		}
		return l1.next;
	}

	public static void printLL(ListNode resNode) {
		while (resNode.next != null) {
			System.out.print("[{ " + resNode.val + " }{" + resNode + "} ] --> ");
			resNode = resNode.next;
		}
		System.out.print("[{ " + resNode.val + " } {" + resNode + "} ]");
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		Map<String, ArrayList> map = new Hashtable<String, ArrayList>();
		map.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
		map.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
		map.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
		map.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
		map.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
		map.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
		map.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
		map.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
		if (digits.length() == 0) {
			return res;
		} else if (digits.length() == 1) {
			return map.get(digits);
		} else if (digits.length() == 2) {
			String s = "";
			for (int i = 0; i < digits.length(); i++) {
//				char ch=digits.charAt(i);
//				log.info(ch);
				s += map.get(Character.toString(digits.charAt(i)));
			}
			log.info(s);
		} else if (digits.length() == 3) {

		} else if (digits.length() == 4) {

		}
		return res;
	}

	public static String commonPrefix(String arr[]) {
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		int j = 0;
		for (int k = 0; k < arr.length; k++) {
			arr[k] = arr[k].trim();
		}
		while (arr.length > 0) {

			char ch = (arr[0].length() > 0) ? arr[0].charAt(j) : ' ';
			if (ch == ' ') {
				break;
			}
			for (int i = 1; i < arr.length; i++) {
				if (j >= arr[i].length()) {
					flag = true;
					break;
				} else {
					if (ch != arr[i].charAt(j)) {
						flag = true;
						break;
					}
				}
			}

			if (flag) {
				break;
			} else {
				sb.append(ch);
				j++;
			}
		}
		return sb.toString();

	}

	static void printSubStr(String str, int low, int high) {
		System.out.println(str.substring(low, high + 1));
	}

	public static void longestSubString1(String s) {
		int n = s.length();
		boolean table[][] = new boolean[n][n];
		int maxLength = 0;
		int start = 0;
		// length 1 substring is palindrome
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;
			maxLength = 1;
		}
		// length 2 if corner element is equals
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				maxLength = 2;
				start = i;
			}
		}

		// if length is greater than 2 than if arr[i+1][J-1]=true and arr[i]==arr[j]
		for (int i = 3; i <= n; i++) {
			for (int k = 0; k < n - i + 1; k++) {

			}
		}

	}

	public static int longestSubstring(String s) {

		int n = s.length();
		int maxLen = 1;

		boolean tab[][] = new boolean[n][n];
		for (int i = 0; i < n; i++)
			tab[i][i] = true;

		int start = 0;
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				tab[i][i + 1] = true;
				start = i;
				maxLen = 2;
			}

		}

		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (tab[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					tab[i][j] = true;
					if (k > maxLen) {
						start = i;
						maxLen = k;
					}
				}

			}
		}
		printSubStr(s, start, start + maxLen - 1);
		return maxLen;
	}

	// time complexity log(n)
	public static boolean isPalindrome(String s) {
		boolean res = true;
		int i = 0;
		int l = s.length() - 1;
		while (i < l) {
			if (s.charAt(i) != s.charAt(l)) {
				res = false;
				return res;
			}
			i++;
			l--;
		}
		return res;
	}

	public static void getTotalVowelsCount(String s) {
		ArrayList<String> res = getSubStr1(s);
		int totalCount = 0;
		for (String s1 : res) {
			totalCount += countVowels(s1);
		}

//		log.info(totalCount);
		log.info(getSubStr(s));
		log.info(getSubStr1(s));
		log.info(getSubStr2(s));
	}

	public static ArrayList<String> getSubStr2(String s) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= s.length() - i; j++) {
				int l = j + i - 1;
				for (int k = j; k <= l; k++) {
					System.out.print(s.charAt(k));
				}
				System.out.print(", ");
			}
		}

		return res;
	}

	public static ArrayList<String> getSubStr1(String s) {
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			String substring = "";
			for (int j = i; j < s.length(); j++) {
				substring += s.charAt(j);
				res.add(substring);
			}
		}

		return res;
	}

	public static ArrayList<String> getSubStr(String s) {
		ArrayList<String> substr = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				substr.add(s.substring(i, j));
			}
		}

		return substr;

	}

	public static int countVowels(String s) {
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
					|| s.charAt(i) == 'u') {
				cnt++;
			}

		}
		return cnt;
	}

	private static int BNS(int nums[], int start, int end, int target) {
		if (start > end) {
			return 0;
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target)
			return mid;
		if (nums[mid] > target)
			return BNS(nums, start, mid - 1, target);
		if (nums[mid] < target)
			return BNS(nums, mid + 1, end, target);
		return 0;
	}

	private static int[] BNB(int[] nums, int target, int start, int end, int res[]) {
		if (start > end) {
			return new int[2];
		}
		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			int i = 0;
			while ((start - i) > 0 && nums[start - i] == target) {
				i++;
			}
			res[0] = start - i;
		}
		if (nums[end] == target) {
			int j = 0;
			while ((end - j > start) && nums[end - j] == target) {
				j++;
			}
			res[1] = end - j;
		}
		return res;

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if ((nums[i] + nums[j] + nums[k]) == 0) {
						List<Integer> rs = new ArrayList<Integer>();
						rs.add(nums[i]);
						rs.add(nums[j]);
						rs.add(nums[k]);
						Collections.sort(rs);
						if (!res.contains(rs)) {
							res.add(rs);
						}
					}
				}
			}
		}
		return res;
	}

	private static String findMaxPrefix(String[] arr) {
		int maxLen = 0;
		for (String s : arr) {
			if (s.length() > maxLen)
				maxLen = s.length();
		}
		int k = 0;
		String common = "";
		boolean flag = true;
		while (k < maxLen) {
			String str1 = "";
			String commonStr = "";
			for (String s : arr) {
				str1 = arr[0];
				if (str1.charAt(k) == s.charAt(k)) {
					flag = true;
				} else {
					flag = false;
					break;
				}

			}
			commonStr += str1.charAt(k);
			if (flag) {
				common += commonStr;
			} else {
				break;
			}
			k++;
		}
		return common;
	}

	public static int isAtoi(String s) {
		String num = "";
		boolean isNegative = false;
		int cnt = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '-') {
				isNegative = true;
				cnt++;
			} else if (ch == '+') {
				isNegative = false;
				cnt++;
			} else if (ch == ' ') {

			} else if (ch >= 48 && ch <= 57) {
				num += ch;
			} else {
				if (num.length() > 0) {
					return Integer.parseInt(num);
				} else {
					return 0;
				}
			}

		}
		if (cnt > 1)
			return 0;
		long tmp = Long.parseLong(num);
		if (tmp > Integer.MAX_VALUE) {
			if (isNegative) {
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}
		if (isNegative) {
			return -(Integer.parseInt(num));
		} else {
			return Integer.parseInt(num);
		}

	}

}
