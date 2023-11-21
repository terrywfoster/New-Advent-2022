package foster.terry.aoc2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 {
    private final List<int[]> commands = new ArrayList<>();
    private final List<List<String>> stacks = new ArrayList<>();

    public Day05(final List<String> input) {
        int splitRow = 0;
        //Find split and load commands
        for (int x = 0; x < input.size(); x++) {
            String line = input.get(x);
            if (line.isBlank())
                splitRow = x;
            if (line.contains("move")) {
                String command = line.replace("move ","").replace(" from ",",").replace(" to ",",");
                commands.add(Arrays.stream(command.split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray());
            }
        }
        //work back from split and load stacks
        for (int x = splitRow-2; x >= 0; x--)
        {
            final String row = input.get(x) + " ";

            for(int y = 0; y <= row.length()-4; y += 4)
            {
                if (stacks.size() <= y/4)
                    stacks.add(new ArrayList<>());

                if (row.charAt(y+1) != ' ')
                    stacks.get(y/4).add(row.substring(y+1,y+2));
            }

        }
    }

    public String solution(int version)
    {
        StringBuilder returnValue = new StringBuilder();
        //Do moves
        for (int[] command : commands) {
            move(version, command[0], command[1]-1, command[2]-1);
        }
        //Get Return Value
        for (List<String> stack : stacks) {
            returnValue.append(stack.get(stack.size()-1));
        }


        return returnValue.toString();
    }

    public void move(int version, int howMany, int fromCol, int toCol) {
        List<String> fromStack = stacks.get(fromCol);
        List<String> toStack = stacks.get(toCol);
        final int fromSize = fromStack.size();
        for(int x = 0; x < howMany; x++) {
            String crate;
            int itemIndex = fromStack.size() - 1;
            if (version == 9001)
                itemIndex = fromSize - howMany;
            crate = fromStack.get(itemIndex);
            fromStack.remove(itemIndex);
            toStack.add(crate);
        }
    }
}
