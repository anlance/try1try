package club.anlan.nowcoder.start1;

public class P2 {
    public static void main(String[] args) {
        P2 p = new P2();
        System.out.println(p.replaceSpace(new StringBuffer("We Are Happy")));
    }

    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
