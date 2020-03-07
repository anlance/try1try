package club.anlan.nowcoder.start1;

public class P6 {
    public static void main(String[] args) {
        P6 p = new P6();
        int[] arr = {1, 2, 3, 4, 5, 6, 7,0};
        System.out.println(p.minNumberInRotateArray(arr));
    }

    // 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素
    // 注意是 非递减 的旋转
    // 因为存在一定的顺序，考虑二分来减少时间
    public int minNumberInRotateArray(int[] array) {
        if (array.length <= 0)
            return 0;
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            if (array[l] < array[r]) {
                break;
            }
            int mid = l + (r - l) / 2;
            if (array[mid] < array[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return array[l];
    }
}
