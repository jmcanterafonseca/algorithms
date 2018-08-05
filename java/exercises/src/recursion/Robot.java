package recursion;


import java.util.ArrayList;
import java.util.List;

// Exercise 8.2 Cracking the coding interview

class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Robot {
    // 1 indicates robot can be there, 0 not
    public static int[][] robotMatrix = {
            {1,0,1,0,0},
            {1,1,1,1,1},
            {0,1,0,1,0},
            {1,1,1,1,1}
    };

    public static void main(String[] args) {
        Coordinates[] way = calculateWay(robotMatrix);

        // Now printing the way
        for(int j = way.length - 1; j >= 0; j--) {
            System.out.println("(" + way[j].x + "," + way[j].y + ")");
        }
    }

    public static Coordinates[] calculateWay(int[][] robotMatrix) {
        List<Coordinates> path = new ArrayList<>();

        // Final coordinate
        Coordinates end = new Coordinates(robotMatrix[0].length - 1,robotMatrix.length - 1);

        wayTo(end,path);

        // Start coordinate
        path.add(new Coordinates(0,0));

        return path.toArray(new Coordinates[0]);
    }

    public static void wayTo(Coordinates destination, List<Coordinates> path) {
        path.add(destination);

        // If destination has been reached return
        if (destination.x == 0 && destination.y == 0) {
            return;
        }

        Coordinates upperPoint = null;

        if(destination.y > 0) {
            upperPoint = new Coordinates(destination.x, destination.y - 1);
        }

        Coordinates leftPoint = null;

        if(destination.x > 0) {
            leftPoint = new Coordinates(destination.x - 1, destination.y);
        }

        boolean allowedUp = (upperPoint != null && robotMatrix[upperPoint.y][upperPoint.x] == 1);
        boolean allowedLeft = (leftPoint != null && robotMatrix[leftPoint.y][leftPoint.x] == 1);

        if (allowedUp && isThereWayFrom(upperPoint)) {
            wayTo(upperPoint, path);
        }
        else if (allowedLeft && isThereWayFrom(leftPoint)) {
            wayTo(leftPoint, path);
        }
    }

    // Checks whether we will be entering into a depth path or not
    public static boolean isThereWayFrom(Coordinates point) {
        boolean wayUp = false;
        boolean wayLeft = false;

        if (point.x - 1 >= 0) {
            wayLeft = robotMatrix[point.y][point.x - 1] == 1;
        }
        if (point.y - 1 >= 0) {
           wayUp = robotMatrix[point.y - 1][point.x] == 1;
        }

        return wayLeft || wayUp;
    }
}
