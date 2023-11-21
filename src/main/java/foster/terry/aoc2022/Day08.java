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
                if (checkTop(x,y) || checkBottom(x,y) || checkLeft(x,y) || checkRight(x,y)) {
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
                scores.add((checkTopTreesSeen(x,y) + 1) * checkBottomTreesSeen(x,y) * checkLeftTreesSeen(x,y) * checkRightTreesSeen(x,y));
            }
        }

        return scores.stream().sorted(Comparator.reverseOrder()).mapToInt(v -> v).toArray()[0];

    }

    public boolean checkTop(int xCoord, int yCoord)
    {
        for (int y = yCoord - 1; y >= 0; y--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return false;
            }
        }
        return true;
    }
    public int checkTopTreesSeen(int xCoord, int yCoord)
    {
        for (int y = yCoord - 1; y >= 0; y--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return yCoord - y;
            }
        }
        return yCoord;
    }
    public boolean checkBottom(int xCoord, int yCoord)
    {
        for (int y = yCoord + 1; y < treeGrid.size(); y++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return false;
            }
        }
        return true;
    }
    public int checkBottomTreesSeen(int xCoord, int yCoord)
    {
        for (int y = yCoord + 1; y < treeGrid.size(); y++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(y).get(xCoord)) {
                return y - yCoord;
            }
        }
        return treeGrid.size() - 1 - yCoord;
    }
    public boolean checkLeft(int xCoord, int yCoord)
    {
        for (int x = xCoord - 1; x >= 0; x--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return false;
            }
        }
        return true;
    }
    public int checkLeftTreesSeen(int xCoord, int yCoord)
    {
        for (int x = xCoord - 1; x >= 0; x--) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return xCoord - x;
            }
        }
        return xCoord;
    }
    public boolean checkRight(int xCoord, int yCoord)
    {
        for (int x = xCoord + 1; x < treeGrid.get(yCoord).size(); x++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return false;
            }
        }
        return true;
    }
    public int checkRightTreesSeen(int xCoord, int yCoord)
    {
        for (int x = xCoord + 1; x < treeGrid.get(yCoord).size(); x++) {
            if (treeGrid.get(yCoord).get(xCoord) <= treeGrid.get(yCoord).get(x)) {
                return x - xCoord;
            }
        }
        return treeGrid.get(yCoord).size() - 1 - xCoord;
    }
}
