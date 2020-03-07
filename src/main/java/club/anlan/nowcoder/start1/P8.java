package club.anlan.nowcoder.start1;

public class P8 {
    public static void main(String[] args) {
        P8 p = new P8();
        System.out.println(p.JumpFloor(3));
    }

    // 跳台阶，青蛙🐸一次可以跳 一阶 或者 2阶
    public int JumpFloor(int target) {
        if(target<=2)
            return target;
        int[] step = new int[target];
        step[0]=1;
        step[1]=2;
        for(int i=2;i<target;++i){
            step[i]=step[i-2]+step[i-1];
        }
        return step[target-1];
    }
}
