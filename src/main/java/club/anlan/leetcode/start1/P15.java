package club.anlan.leetcode.start1;

import java.util.*;

public class P15 {
    public static void main(String[] args) {
        P15 p = new P15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List temp = p.threeSum(nums);
        temp.forEach(System.out::println);
    }

    // Q: 返回所有 3个数字和为 0 的组合（Nums 中数字可能重复，且无序）
    // A: 把三数之和 变为两数之和问题，剩下的关键就是去重
    // 利用 set 去重，存储当前三个数的顺序字符串， 最后 list 的顺序不一顶一样就可以
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            // map 中 装的是每个数字出现的次数
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {

                int temp = nums[i] + nums[j]; // 找到两数之和
                int contrary = -temp; //和为 0 需要的第三个数
                if (map.containsKey(contrary)) {
                    // 排除 第三个数与第一个和第二数使用的是同一个数
                    int isSame = map.get(contrary);
                    if (contrary == nums[i])
                        isSame--;
                    if (contrary == nums[j])
                        isSame--;
                    if (isSame > 0) {
                        List<Integer> triple = new ArrayList<>();
                        int[] listArray = {nums[i], nums[j], contrary};
                        Arrays.sort(listArray);
                        triple.add(listArray[0]);
                        triple.add(listArray[1]);
                        triple.add(listArray[2]);
                        if (set.contains(listArray[0] + "" + listArray[1] + "" + listArray[2]))
                            continue;
                        res.add(triple);
                        // 用于 去重
                        set.add(listArray[0] + "" + listArray[1] + "" + listArray[2]);
                    }
                }
            }

        }
        return res;
    }
}
