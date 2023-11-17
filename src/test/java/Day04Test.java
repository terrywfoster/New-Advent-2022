import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day04;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day04Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day04/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day04/PuzzleInput.txt"))
                        .toURI()));

        final Day04 part1Test = new Day04(testInput);
        final Day04 part1Puzzle = new Day04(puzzleInput);

        Assertions.assertThat(part1Test.fullyContained()).isEqualTo(2);
        Assertions.assertThat(part1Puzzle.fullyContained()).isEqualTo(571);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day04/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day04/PuzzleInput.txt"))
                        .toURI()));

        final Day04 part2Test = new Day04(testInput);
        final Day04 part2Puzzle = new Day04(puzzleInput);

        Assertions.assertThat(part2Test.overlaps()).isEqualTo(4);
        Assertions.assertThat(part2Puzzle.overlaps()).isEqualTo(917);
    }
}
