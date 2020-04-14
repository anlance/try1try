package club.anlan.leetcode.lower1000.lower100.start61;

import java.util.ArrayList;
import java.util.List;

public class P78 {
    public static void main(String[] args) {
        P78 p = new P78();
        int[] nums = {1,2,3};
        List<List<Integer>> res = p.subsets(nums);
        res.forEach(li-> System.out.println(li.toString()));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=1;i<nums.length+1;++i){
            dfs(i,0,nums,list,res);
        }
        return res;
    }

    public void dfs(int n, int i,int[] nums,List<Integer> list,List<List<Integer>> res){
        if(n==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<nums.length;++j){
            list.add(nums[j]);
            dfs(n-1,j+1,nums,list,res);
            list.remove(list.size()-1);
        }
    }
}
