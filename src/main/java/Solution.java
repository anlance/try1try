import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String[] strs = new String[k];
        int index = 0;
        String res = "";
        int maxD = 0;
        int maxL = 0;
        int maxU = 0;
        int maxR = 0;
        int[] sxx = new int[k];
        int[] syy = new int[k];
        int[] exx = new int[k];
        int[] eyy = new int[k];

        for(int i=0;i<k;i++){
            sxx[index] = sc.nextInt();
            syy[index] = sc.nextInt();
            index++;
        }
        index = 0;
        for(int i=0;i<k;i++){
            exx[index] = sc.nextInt();
            eyy[index] = sc.nextInt();
            index++;
        }


        index = 0;
        while (index < k) {
            String str = "";
            int sx = sxx[index];
            int sy = syy[index];
            int ex = exx[index];
            int ey = eyy[index];
            if (ex > sx) {
                int temp = ex - sx;
                maxD=Math.max(temp,maxD);
            }
            if (sy < ey) {
                int temp = ey - sy;
                maxL=Math.max(temp,maxL);
            }
            if (sx > ex) {
                int temp = sx - ex;
                maxU=Math.max(temp,maxU);
            }
            if (ey < sy) {
                int temp = sy - ey;
                maxR=Math.max(temp,maxR);
            }
            strs[index] = str;
            ++index;
        }

        for(int i=0;i<maxD;++i){
            res+="D";
        }
        for(int i=0;i<maxL;++i){
            res+="L";
        }
        for(int i=0;i<maxU;++i){
            res+="U";
        }
        for(int i=0;i<maxR;++i){
            res+="R";
        }
        if(res.length()>2*n*m){
            System.out.println(-1);
        } else {
            System.out.println(res.length());
            System.out.println(res);
        }
    }
}
