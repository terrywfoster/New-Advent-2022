package foster.terry.aoc2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day08 {
    final private List<List<Integer>> treeGrid = new ArrayList<>();
    public Day08(final List<String> input) {

        //Load grid
        for(String line : input) {
            treeGrid.add(line.chars().mapToObj(e -> Character.getNumericValue((char)e)).collect(Collectors.toList()));
        }
    }

    public int visibleOutsideCount() {
        //Start with outside trees
        int totalCount = (treeGrid.get(0).size() * 2) + (2 * (treeGrid.size() - 2));

        for (int y = 1; y < treeGrid.size()-1; y++) {
            for (int x = 1; x < treeGrid.get(y).size()-1; x++) {
                if (checkTopTreesSeen(x,y,1) == y
                        || checkBottomTreesSeen(x,y,1) == (treeGrid.size() - 1) - y
                        || checkLeftTreesSeen(x,y,1) == x
                        || checkRightTreesSeen(x,y,1) == (treeGrid.get(y).size() - 1) - x) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
    public int highestScore() {
        List<Integer> scores = new ArrayList<>();
        for (int y = 0; y < treeGrid.size(); y++) {
            for (int x = 0; x < treeGrid.get(y).size(); x++) {
                scores.add(checkTopTreesSeen(x,y,0) * checkBottomTreesSeen(x,y,0) * checkLeftTreesSeen(x,y,0) * checkRightTreesSeen(x,y,0));
            }
        }

        return scores.stream().sorted(Comparator.reverseOrder()).mapToInt(v -> v).toArray()[0];

    }

    public int checkTopTreesSeen(int xCoord, int yCoord, int less)
    {
        for (int y = yCoord - 1; y >= 0; y--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return yCoord - y - less;
            }
        }
        return yCoord;
    }
    public int checkBottomTreesSeen(int xCoord, int yCoord, int less)
    {
        for (int y = yCoord + 1; y < treeGrid.size(); y++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return y - yCoord - less;
            }
        }
        return treeGrid.size() - 1 - yCoord;
    }
    public int checkLeftTreesSeen(int xCoord, int yCoord, int less)
    {
        for (int x = xCoord - 1; x >= 0; x--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return xCoord - x - less;
            }
        }
        return xCoord;
    }
    public int checkRightTreesSeen(int xCoord, int yCoord, int less)
    {
        for (int x = xCoord + 1; x < treeGrid.get(yCoord).size(); x++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return x - xCoord - less;
            }
        }
        return treeGrid.get(yCoord).size() - 1 - xCoord;
    }
}
