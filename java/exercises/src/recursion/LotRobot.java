package recursion;

import java.util.ArrayList;
import java.util.List;

public class LotRobot {
    private static int[][] lotConfig = {
            {1,0,1,0},
            {1,1,1,0},
            {1,9,0,0},
            {0,1,0,0}
    };

    private static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(lotConfig.length,lotConfig[0].length,lotConfig));
    }

    // Returns shortest path to the obstacle
    private static int solution(int rows, int cols, int[][]lotConfig) {
        boolean[][] visited = new boolean[rows][cols];

        Coordinates start = new Coordinates(0,0);


        List<List<Coordinates>> paths = new ArrayList<>();

        List<Coordinates> coords = findPath(start, lotConfig);
    }

    // Checks whether we will be entering into a depth path or not
    private static boolean isThereWayFrom(Coordinates point,int[][] lotConfig) {
        boolean wayDown = false;
        boolean wayRight = false;

        if (point.c + 1 < lotConfig[0].length) {
            wayRight = lotConfig[point.r][point.c + 1] == 1;
        }
        if (point.r + 1 >= lotConfig.length) {
            wayDown = lotConfig[point.r + 1][point.c] == 1;
        }

        return wayDown || wayRight;
    }

    private static int findPath(Coordinates start, int[][] lotConfig, boolean[][] visited) {
        if ()
    }
}
