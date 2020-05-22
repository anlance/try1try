package club.anlan.nowcoder.start11;

import java.util.Arrays;

public class P13 {

    public static void main(String[] args) {
        P13 p = new P13();
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        p.reOrderArray(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    // 调整数组顺序使奇数位于偶数前面

    // 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
    // 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    public void reOrderArray(int[] array) {
        int index = -1;
        int i = 0;
        while (i < array.length) {
            if (array[i] % 2 == 0) {
                if (index == -1) {
                    index = i;
                }
            } else {
                if (index != -1) {
                    int temp = array[i];
                    for (int j = i; j > index; --j) {
                        array[j] = array[j - 1];
                    }
                    array[index] = temp;
                    i = index + 1;
                    index = -1;
                    continue;
                }
            }
            ++i;
        }
    }
}
