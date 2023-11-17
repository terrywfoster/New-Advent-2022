package foster.terry.aoc2022.Day02;

import java.util.ArrayList;
import java.util.List;

public class Day02 {

    private final List<shapeRules> shapes = new ArrayList<>();
    private final List<String> lines;

    public Day02(final List<String> input)
    {
        this.shapes.add(new shapeRules(myShapeName.ROCK.value, theirShapeName.ROCK.value, 1, theirShapeName.SCISSORS.value, theirShapeName.PAPER.value));
        this.shapes.add(new shapeRules(myShapeName.PAPER.value, theirShapeName.PAPER.value, 2, theirShapeName.ROCK.value, theirShapeName.SCISSORS.value));
        this.shapes.add(new shapeRules(myShapeName.SCISSORS.value, theirShapeName.SCISSORS.value, 3, theirShapeName.PAPER.value, theirShapeName.ROCK.value));

        this.lines = input;
    }

    public int part1()
    {
        int totalScore = 0;
        for(String line : lines)
        {
            // process the line
            String[] guidePlays = line.split(" ");
            String theirShape = guidePlays[0];
            String myAction = guidePlays[1];

            shapeRules playShape = shapes.stream().filter(s -> myAction.equals(s.myShape)).findAny().orElse(null);
            if (playShape != null)
            {
                totalScore += playShape.playScore;

                //Determine win score
                if (playShape.winShape.equals(theirShape))
                {
                    totalScore += 6;
                }
                //Determine draw score
                if (playShape.shape.equals(theirShape))
                {
                    totalScore += 3;
                }
            }


        }

        return totalScore;
    }

    public int part2()
    {
        int totalScore = 0;
        for(String line : lines)
        {
            // process the line
            String[] guidePlays = line.split(" ");
            String theirShape = guidePlays[0];
            String myAction = guidePlays[1];

            shapeRules myShape = shapes.stream().filter(s ->
                        (theirShape.equals(s.winShape) && myAction.equals(actionName.WIN.value))
                        ||
                        (theirShape.equals(s.shape) && myAction.equals(actionName.TIE.value))
                        ||
                        (theirShape.equals(s.loseShape) && myAction.equals(actionName.LOSE.value))
                        ).findAny().orElse(null);
            if (myShape != null)
            {
                totalScore += myShape.playScore;

                //Determine win score
                if ( myAction.equals(actionName.WIN.value) )
                {
                    totalScore += 6;
                }
                //Determine tie score
                if ( myAction.equals(actionName.TIE.value) )
                {
                    totalScore += 3;
                }
            }
        }

        return totalScore;
    }
}

