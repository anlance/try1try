package club.anlan.nowcoder.start21;

import java.util.Arrays;

public class P23 {

    // 二叉搜索树的后序遍历序列
    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
    // 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence==null || sequence.length<=0)
            return false;
        return VerifySquenceOfBST2(sequence);
    }
    public boolean VerifySquenceOfBST2(int[] sequence) {
        if(sequence.length<=1)
            return true;
        int temp = sequence[sequence.length - 1];
        int index = -1;
        for (int i = 0; i < sequence.length; ++i) {
            if (sequence[i] < temp) {
                if (index != -1)
                    return false;
                continue;
            }
            if (index == -1)
                index = i;
        }
        return VerifySquenceOfBST2(Arrays.copyOfRange(sequence, 0, index)) && VerifySquenceOfBST2(Arrays.copyOfRange(sequence,index, sequence.length - 1));
    }
}
