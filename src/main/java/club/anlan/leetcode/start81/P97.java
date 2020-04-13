package club.anlan.leetcode.start81;

public class P97 {
    public static void main(String[] args) {
        P97 p = new P97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(p.isInterleave(s1,s2,s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index1 == s1.length() && index2 == s2.length())
            return true;
        if (index1 == s1.length()) {
            if (s2.charAt(index2) != s3.charAt(index3))
                return false;
            return isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1);
        }
        if (index2 == s2.length()) {
            if (s1.charAt(index1) != s3.charAt(index3))
                return false;
            return isInterleave(s1, s2, s3, index1+1, index2, index3+1);
        }
        if (s1.charAt(index1) == s2.charAt(index2)) {
            if (s3.charAt(index3) != s1.charAt(index1))
                return false;
            else {
                return isInterleave(s1, s2, s3, index1 + 1, index2, index3 + 1)
                        || isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1);
            }
        }
        if (s1.charAt(index1) == s3.charAt(index3))
            return isInterleave(s1, s2, s3, index1+1, index2, index3+1);
        if (s2.charAt(index2) == s3.charAt(index3))
            return isInterleave(s1, s2, s3, index1, index2 + 1, index3 + 1);
        return false;
    }
}
