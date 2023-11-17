import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day02.Day02;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day02Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var dayOneTestInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day02/TestInput.txt"))
                        .toURI()));
        final var dayOnePuzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day02/PuzzleInput.txt"))
                        .toURI()));

        final Day02 part1Test = new Day02(dayOneTestInput);
        final Day02 part1Puzzle = new Day02(dayOnePuzzleInput);

        Assertions.assertThat(part1Test.totalScore()).isEqualTo(15);
        Assertions.assertThat(part1Puzzle.totalScore()).isEqualTo(10624);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var dayOneTestInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day02/TestInput.txt"))
                        .toURI()));
        final var dayOnePuzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day02/PuzzleInput.txt"))
                        .toURI()));

        final Day02 part2Test = new Day02(dayOneTestInput);
        final Day02 part2Puzzle = new Day02(dayOnePuzzleInput);

        Assertions.assertThat(part2Test.totalDecodedScore()).isEqualTo(12);
        Assertions.assertThat(part2Puzzle.totalDecodedScore()).isEqualTo(14060);
    }
}
