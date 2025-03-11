// class Solution {
//     public int numberOfSubstrings(String s) {
//         int[] freq = new int[3]; 
//         int left = 0, ans = 0;

//         for (int right = 0; right < s.length(); right++) {
//             freq[s.charAt(right) - 'a']++;

//             while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
//                 ans += s.length() - right;
//                 freq[s.charAt(left) - 'a']--;
//                 left++;
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int left = 0;
        int[] charCount = new int[3];

        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'a']++;

            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                count += s.length() - right;
                charCount[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}