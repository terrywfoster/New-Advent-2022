import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day03;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day03Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day03/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day03/PuzzleInput.txt"))
                        .toURI()));

        final Day03 part1Test = new Day03(testInput);
        final Day03 part1Puzzle = new Day03(puzzleInput);

        Assertions.assertThat(part1Test.priorityTotal()).isEqualTo(157);
        Assertions.assertThat(part1Puzzle.priorityTotal()).isEqualTo(8185);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day03/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day03/PuzzleInput.txt"))
                        .toURI()));

        final Day03 part2Test = new Day03(testInput);
        final Day03 part2Puzzle = new Day03(puzzleInput);

        Assertions.assertThat(part2Test.badgeTotal(3)).isEqualTo(70);
        Assertions.assertThat(part2Puzzle.badgeTotal(3)).isEqualTo(2817);
    }
}
