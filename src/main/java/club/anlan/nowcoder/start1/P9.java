package club.anlan.nowcoder.start1;

public class P9 {
    public static void main(String[] args) {
        P9 p = new P9();
    }

    // 变态跳，每次可以跳 1~k(当前) 阶
    public int JumpFloorII(int target) {
        if(target<=2)
            return target;
        int[] step = new int[target];
        step[0]=1;
        step[1]=2;
        int temp = step[0]+step[1];
        for(int i=2;i<target;++i){
            step[i]=temp+1;
            temp+=step[i];
        }
        return step[target-1];
    }
}
