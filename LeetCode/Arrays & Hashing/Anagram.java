/* https://leetcode.com/problems/valid-anagram/description/ */


import java.util.Scanner;

public class Anagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // for 26 lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // increment count for s ; Initially value is zero for all index in count array
            count[t.charAt(i) - 'a']--; // decrement count for t
        }

        for (int val : count) {
            if (val != 0) return false; // mismatch in counts
        }

        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 1st string");
        String s= sc.nextLine();
        System.out.println("Enter the 2nd String");
        String t = sc.nextLine();

        Anagram b= new Anagram();
        System.out.println("Are they anagrams? " + b.isAnagram(s, t));


        sc.close();
    }
}





/*

Above code will not works if the inputs contain Unicode characters  

 * import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();    // Map is an Interface

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            map.put(ch1, map.getOrDefault(ch1, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }

        for (int val : map.values()) {
            if (val != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1:");
        String s = sc.nextLine();
        System.out.println("Enter string 2:");
        String t = sc.nextLine();

        Solution sol = new Solution();
        System.out.println("Are they anagrams? " + sol.isAnagram(s, t));
    }
}

 * 
 * 
 * 
 */