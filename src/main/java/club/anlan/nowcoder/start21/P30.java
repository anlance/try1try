package club.anlan.nowcoder.start21;

public class P30 {
    public static void main(String[] args) {
        P30 p = new P30();
        int[] num ={1,-2,3,10,-4,7,2,-5};
        System.out.println(p.FindGreatestSumOfSubArray(num));
    }

    // 连续子数组的最大和
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int[] step = new int[len];
        int max = array[0];
        step[0] = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (step[i - 1] > 0) {
                step[i] = step[i - 1] + array[i];
            }
            else
                step[i] = array[i];
            if(step[i]>max){
                max=step[i];
            }
        }
        return max;
    }
}
