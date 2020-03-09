package club.anlan.leetcode.start21;

public class P28 {
    public static void main(String[] args) {
        P28 p = new P28();
        String parent = "aaaaa";
        String child = "bba";
        System.out.println(p.strStr(parent, child));
    }

    // 返回第一次出现字串的位置，若无返回 -1
    public int strStr(String haystack, String needle) {
        if (needle.length() <= 0)
            return 0;
        int indexParent = 0;
        int indexChild = 0;
        int i = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                indexParent = i + 1;
                indexChild = 1;
                while (indexParent < haystack.length() && indexChild < needle.length()) {
                    if (haystack.charAt(indexParent) != needle.charAt(indexChild))
                        break;
                    ++indexParent;
                    ++indexChild;
                }
                if (indexChild == needle.length())
                    return i;
            }
            ++i;
        }
        return -1;
    }
}
