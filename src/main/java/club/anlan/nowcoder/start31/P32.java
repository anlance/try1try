package club.anlan.nowcoder.start31;

import java.util.ArrayList;
import java.util.List;

// 把数组排成最小的数
public class P32 {

    public static void main(String[] args) {
        P32 p = new P32();
        int[] number = {3, 32, 321};
        System.out.println(p.PrintMinNumber(number));
    }

    //输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
    // 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
    // 则打印出这三个数字能排成的最小数字为321323。
    public String PrintMinNumber(int[] numbers) {
        String res = "";
        // 当作字符串排序
        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        list.sort((a, b) -> (a + b).compareTo(b + a)); // 比较器
        for (String i : list)
            res += i;
        return res;
    }
}
