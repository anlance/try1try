package club.anlan.leetcode.lower1000.lower100.start1;

public class P8 {
    public static void main(String[] args) {
        String temp = "0-1";
        P8 p = new P8();
        System.out.println(p.myAtoi(temp));
    }

    public int myAtoi(String str) {
        int startIndex = -1;
        int endIndex = str.length();
        boolean isNeg = false;
        for (int i = 0; i < str.length(); ++i) {
            // 去除开始的空格
            if (str.charAt(i) == ' '&& startIndex == -1)
                continue;
            // 找到起点
            if (str.charAt(i) == '-'|| str.charAt(i)=='+' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                if (startIndex == -1) {
                    startIndex = i;
                    // 是一个负数
                    if (str.charAt(i) == '-')
                        isNeg = true;
                }
                // 其他位置出现 '-'
                else if(str.charAt(i)=='-' || str.charAt(i)=='+'){
                    endIndex=i;
                    break;
                }
            } else {// 终点
                endIndex = i;
                break;
            }
        }
        // 并不是以 '-' 或者数字开头
        if(startIndex==-1)
            return 0;
        return toInt(str.substring(startIndex, endIndex), isNeg);
    }

    public int toInt(String temp, boolean isNeg) {
        String str;
        // 将 '-' '+' 号抽离出
        if (isNeg || temp.charAt(0)=='+') {
            str = new StringBuilder(temp.substring(1)).toString();
        } else {
            str = new StringBuilder(temp).toString();
        }
        // 字符串为空字符串
        if(str.length()==0)
            return 0;
        // 去掉 0
        int index = 0;
        while (index<str.length() && str.charAt(index)=='0'){
            ++index;
        }
        str = str.substring(index);
        if(str.length()==0)
            return 0;
        // 溢出 返回
        String maxStr = "2147483647";
        if (str.length() >= 10) {
            if (str.length() > 10)
                return isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            else if (str.compareTo(maxStr) > 0)
                return isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        int res = 0;
        if (isNeg) {
            res = Integer.parseInt("-" + str);
        } else {
            res = Integer.parseInt(str);
        }
        return res;
    }
}
