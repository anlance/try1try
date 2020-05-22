package club.anlan.nowcoder.start21;

import java.util.Arrays;

public class P28 {
    public static void main(String[] args) {
        P28 p = new P28();
        int[] num = {1,2,3,2,2,2,5,4,2};
        System.out.println(p.MoreThanHalfNum_Solution(num));
    }

    // 数组中出现次数超过一半的数字
    // 数组中有一个数字出现的次数超过数组长度的一半，
    // 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        Arrays.sort(array);
        int mid = len / 2;
        int number = 0;
        int l = mid;
        int r = mid;
        while (l > 0) {
            --l;
            if (array[mid] != array[l])
                break;
            ++number;
        }
        while (r < len) {
            if (array[mid] != array[r])
                break;
            ++r;
            ++number;
        }
        if(number>mid){
            return array[mid];
        }
        return 0;
    }
}
