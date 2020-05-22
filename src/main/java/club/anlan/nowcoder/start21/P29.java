package club.anlan.nowcoder.start21;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P29 {
    public static void main(String[] args) {
        P29 p = new P29();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        List list = p.GetLeastNumbers_Solution(input, 4);
        list.forEach(i -> System.out.println(i));
    }

    // 最小的 k 个数
    // 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList list = new ArrayList();
        if(k>input.length || k==0)
            return list;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> (b - a));
        for (int i = 0; i < input.length; ++i) {
            if (pq.size() < k) {
                pq.offer(input[i]);
            } else {
                if (input[i] < pq.peek()) {
                    pq.poll();
                    pq.offer(input[i]);
                }
            }
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        ArrayList ans = new ArrayList();
        for(int i=list.size()-1;i>=0;--i){
            ans.add(list.get(i));
        }
        return ans;
    }
}
