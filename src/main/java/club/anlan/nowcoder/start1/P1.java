package club.anlan.nowcoder.start1;

public class P1 {
    public static void main(String[] args) {
        P1 p = new P1();
        int[][] array = {{0, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}};
        System.out.println(p.Find(8, array));
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0)
            return false;
        return find(target, array, 0, 0);

    }

    public boolean find(int target, int[][] array, int x, int y) {
        if (x >= array.length)
            return false;
        if (y >= array[0].length)
            return false;
        if (target == array[x][y])
            return true;
        if (target > array[x][y])
            return find(target, array, x + 1, y) || find(target, array, x, y + 1);
        return false;
    }

}
