package foster.terry.aoc2022;

import java.util.ArrayList;
import java.util.List;

public class Day02 {

    private final List<shapeRules> shapes = new ArrayList<>();
    private final List<String> lines;

    public Day02(final List<String> input)
    {
        this.shapes.add(new shapeRules(shapeNames.ROCK.value, shapeNames.SCISSORS.value, shapeNames.PAPER.value));
        this.shapes.add(new shapeRules(shapeNames.PAPER.value, shapeNames.ROCK.value, shapeNames.SCISSORS.value));
        this.shapes.add(new shapeRules(shapeNames.SCISSORS.value, shapeNames.PAPER.value, shapeNames.ROCK.value));

        this.lines = input;
    }

    public int totalScore()
    {
        int totalScore = 0;
        for(String line : lines)
        {
            final int theirShape = line.charAt(0) - 'A';
            final int myShape = line.charAt(2) - 'X';

            final shapeRules playShape = shapes.stream().filter(s -> myShape == s.shape).findAny().orElse(null);
            if (playShape != null)
            {
                //Add score for shape played
                totalScore += myShape + 1;

                //Determine outcome score
                if (playShape.winShape == theirShape)
                {
                    totalScore += 6;
                }
                //Determine draw score
                if (playShape.shape == theirShape)
                {
                    totalScore += 3;
                }
            }


        }

        return totalScore;
    }


    public int totalDecodedScore()
    {
        int totalScore = 0;
        for(String line : lines)
        {
            final int theirShape = line.charAt(0) - 'A';
            final int outcome = line.charAt(2) - 'X';

            final shapeRules myShape = shapes.stream().filter(s ->
                        (theirShape == s.winShape && outcome == actionNames.WIN.value)
                        ||
                        (theirShape == s.shape && outcome == actionNames.TIE.value)
                        ||
                        (theirShape == s.loseShape && outcome == actionNames.LOSE.value)
                        ).findAny().orElse(null);
            if (myShape != null)
            {
                totalScore += myShape.shape + 1 + (outcome * 3);
            }
        }

        return totalScore;
    }

    public static class shapeRules {
        public int shape;
        public int winShape;
        public int loseShape;

        public shapeRules(int shape, int winShape, int loseShape) {
            this.shape = shape;
            this.winShape = winShape;
            this.loseShape = loseShape;
        }
    }
    public enum shapeNames {
        ROCK(0),
        PAPER(1),
        SCISSORS(2);

        public final int value;

        shapeNames(int value)
        {
            this.value = value;
        }
    }
    public enum actionNames {
        WIN(2),
        TIE(1),
        LOSE(0);

        public final int value;

        actionNames(int value)
        {
            this.value = value;
        }

    }
}

