package club.anlan.leetcode.lower1000.lower200.start101;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Collections.singletonList(1)));
        if(numRows == 1) {
            return res;
        }
        res.add(Arrays.asList(1,1));
        if (numRows == 2) {
            return res;
        }
        List<Integer> lastList = Arrays.asList(1,1);
        for(int i=3; i <= numRows; i++)   {
            List<Integer> thisList = new ArrayList<>(i);
            for (int j=0; j < i; j++) {
                if (j==0) {
                    thisList.add(1);
                } else if (j == i-1) {
                    thisList.add(1);
                } else {
                    thisList.add(lastList.get(j) + lastList.get(j-1));
                }
            }
            res.add(thisList);
            lastList = thisList;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new P118().generate(5)));
    }
}

