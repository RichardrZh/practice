import java.util.HashSet;

class Solution {

    /**
     * Finds the length of the longest substring for a given string.
     * @param s A string.
     * @return The length of the longest substring in s.
     */
    public int lengthOfLongestSubstring(String s) {

        // init a 'seen' set for charcters that we have seen before
        HashSet<Character> seen = new HashSet<Character>();

        // init pointers for a sliding window
        int p1 = 0;
        int p2 = 0;

        // init 'max' variable that stores the longest substring seen so far
        int max = 0;

        // declare curr char var for main loop
        char currChar;

        //main loop
        while (p2 < s.length()) {
            
            // init curr
            currChar = s.charAt(p2);

            // check if we have seen char at s2
            if (seen.contains(currChar)) {
                // we have seen char at s2

                // record max substring (if able)
                // p2-p1 is the length of the current substring
                if (max < p2-p1) {
                    max = p2-p1;
                } 

                // increment s1 until we pop currChar from seen
                while (seen.contains(currChar)) {
                    seen.remove(s.charAt(p1));
                    p1++;
                }

            } else {
                // we have not seen char at s2
                // add currChar to seen and continue
                seen.add(currChar);
                p2++;
            }
        }   
        
        // we have to check max for an edgecase where we exit 
        // the main loop from the else branch without recording max substring
        // p2-p1 is the length of the current substring
        return max < p2-p1 ? p2-p1 : max;
    }
}