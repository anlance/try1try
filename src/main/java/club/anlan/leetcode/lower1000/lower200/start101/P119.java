package club.anlan.leetcode.lower1000.lower200.start101;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类
 *
 * @author lan
 * @version 1.0
 * @date 2021/5/7 19:25
 */
public class P119 {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return Collections.singletonList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1,1);
        }
        List<Integer> lastList = Arrays.asList(1,1);
        List<Integer> thisList = new ArrayList<>();
        for(int i=2; i <= rowIndex; i++)   {
            thisList = new ArrayList<>();
            for (int j=0; j <= i; j++) {
                if (j==0) {
                    thisList.add(1);
                } else if (j == i) {
                    thisList.add(1);
                } else {
                    thisList.add(lastList.get(j) + lastList.get(j-1));
                }
            }
            lastList = thisList;
        }
        return thisList;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new P119().getRow(3)));
    }
}
