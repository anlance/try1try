package club.anlan.leetcode.start81;

public class P87 {
    public static void main(String[] args) {
        P87 p = new P87();
        String s1 = "abcde";
        String s2 = "caebd";
        System.out.println(p.isScramble(s1,s2));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s2.length() == 1) {
            return s1.equals(s2);
        }
        if (s2.length() == 2) {
            return s1.equals(s2) || (s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0));
        }
        // when failed, return fast
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++)
            if( s1Array[i] != s2Array[i] )
                return false;

        int l = 0;
        int r = s2.length();
        for(int i=1;i<s2.length();++i){
            boolean isRight =  (isScramble(s1.substring(l, i), s2.substring(l, i))
                    && isScramble(s1.substring(i, r), s2.substring(i, r)))
                    || (isScramble(s1.substring(l, i), s2.substring(r-i, r)) // i == the next s1.length()
                    && isScramble(s1.substring(i, r), s2.substring(l,r-i)));
            if(isRight)
                return true;
        }
        return false;
    }
}
