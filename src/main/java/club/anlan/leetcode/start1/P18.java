package club.anlan.leetcode.start1;

import javafx.util.Pair;

import java.util.*;

public class P18 {
    public static void main(String[] args) {
        P18 p = new P18();
        int[] nums = {-6,-10,-6,1,-1,-2,3,3,-1,-2,2,-3,5,2,0,-5,-6,0,-5};
        List list = p.fourSum(nums, -15);
        list.forEach(i -> System.out.println(i));
    }

    // 把 4 数之和 转化为 2数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();

        Arrays.sort(nums);
        Map<String, Pair<Integer, Integer>> map = new HashMap<>(); // 存储两个数的位置，以及该两个数的和
        Map<Integer, Integer> sumNumber = new HashMap<>(); // 存储和的个数
        Set<String> set = new HashSet<>();  // 用于去重
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int temp = nums[i] + nums[j];
                int number = sumNumber.getOrDefault(temp, 0);
                map.put(temp + "&" + number, new Pair<>(i, j));
                ++number;
                sumNumber.put(temp, number);
            }
        }

//        map.forEach((i,j)-> System.out.println("map:"+i+":"+j));
//        sumNumber.forEach((i,j)-> System.out.println("sumNumber:"+i+":"+j));

        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int temp = target - (nums[i] + nums[j]); // 和为 target 需要的另外两个数的和
                if (!sumNumber.containsKey(temp))
                    continue;
                int number = sumNumber.get(temp);
                for (int k = 0; k < number; k++) {
                    Pair<Integer, Integer> pair = map.get(temp + "&" + k);
                    if (pair == null)
                        continue;
                    // 排除使用同一个位置的情况
                    if (pair.getKey() == i || pair.getKey() == j || pair.getValue() == i || pair.getValue() == j)
                        continue;
                    int[] array = {nums[i], nums[j], nums[pair.getKey()], nums[pair.getValue()]};
                    Arrays.sort(array);
                    if (set.contains(array[0] + "" + array[1] + "" + array[2] + "" + array[3]))
                        continue;
                    set.add(array[0] + "" + array[1] + "" + array[2] + "" + array[3]);
                    List<Integer> list = Arrays.asList(array[0], array[1], array[2], array[3]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
