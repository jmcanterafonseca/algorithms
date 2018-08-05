package recursion;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Exercise 8.2 Cracking the coding interview

class Point {
    public int r;
    public int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Robot2 {
    // 1 indicates robot can be there, 0 not
    public static boolean[][] maze = {
            {true, false,true, false,false},
            {true, true, true, true, true},
            {false,true, false,true, false},
            {true, true, true, true, true}
    };

    public static void main(String[] args) {
        List<Point> path = getPath(maze);

        if (path == null) {
            return;
        }

        // Now printing the way
        for(Point p:path) {
            System.out.println("(" + p.r + "," + p.c + ")");
        }
    }

    private static List getPath(boolean[][] maze) {
        List<Point> path = new ArrayList<>();

        HashSet<Point> failed = new HashSet<>();

       if (getPath(maze,maze.length - 1,maze[0].length -1,path, failed)) {
           return path;
       }

       return null;
    }

    private static boolean getPath(boolean[][] maze,int r, int c, List<Point> path, HashSet<Point> failed) {
        if (c < 0 || r < 0 || !maze[r][c]) {
            return false;
        }

        Point p = new Point(r,c);

        if (failed.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (r == 0 && c == 0);

        if (isAtOrigin || getPath(maze,r - 1, c, path,failed) || getPath(maze,r,c - 1, path,failed)) {
            path.add(p);
            return true;
        }

        failed.add(p);
        return false;
    }
}
