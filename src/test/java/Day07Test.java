import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day07;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day07Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day07/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day07/PuzzleInput.txt"))
                        .toURI()));

        final Day07 part1Test = new Day07(testInput);
        final Day07 part1Puzzle = new Day07(puzzleInput);

        Assertions.assertThat(part1Test.getTotalSizeUnder(100000)).isEqualTo(95437);
        Assertions.assertThat(part1Puzzle.getTotalSizeUnder(100000)).isEqualTo(1477771);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day07/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day07/PuzzleInput.txt"))
                        .toURI()));

        final Day07 part2Test = new Day07(testInput);
        final Day07 part2Puzzle = new Day07(puzzleInput);

        Assertions.assertThat(part2Test.freeUpSizeMin(30000000)).isEqualTo(24933642);
        Assertions.assertThat(part2Puzzle.freeUpSizeMin(30000000)).isEqualTo(3579501);
    }
}
