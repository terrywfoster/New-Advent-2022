import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day08;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day08Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day08/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day08/PuzzleInput.txt"))
                        .toURI()));

        final Day08 part1Test = new Day08(testInput);
        final Day08 part1Puzzle = new Day08(puzzleInput);

        Assertions.assertThat(part1Test.visibleOutsideCount()).isEqualTo(21);
        Assertions.assertThat(part1Puzzle.visibleOutsideCount()).isEqualTo(1787);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day08/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day08/PuzzleInput.txt"))
                        .toURI()));

        final Day08 part2Test = new Day08(testInput);
        final Day08 part2Puzzle = new Day08(puzzleInput);

        Assertions.assertThat(part2Test.highestScore()).isEqualTo(8);
        Assertions.assertThat(part2Puzzle.highestScore()).isEqualTo(440640);
    }
}
