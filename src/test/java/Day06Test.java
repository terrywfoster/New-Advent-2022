import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day06;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day06Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day06/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day06/PuzzleInput.txt"))
                        .toURI()));

        final Day06 part1Test = new Day06(testInput.get(0));
        final Day06 part1Puzzle = new Day06(puzzleInput.get(0));

        Assertions.assertThat(part1Test.findFirstMarker(4)).isEqualTo(7);
        Assertions.assertThat(part1Puzzle.findFirstMarker(4)).isEqualTo(1848);
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day06/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day06/PuzzleInput.txt"))
                        .toURI()));

        final Day06 part2Test = new Day06(testInput.get(0));
        final Day06 part2Puzzle = new Day06(puzzleInput.get(0));

        Assertions.assertThat(part2Test.findFirstMarker(14)).isEqualTo(19);
        Assertions.assertThat(part2Puzzle.findFirstMarker(14)).isEqualTo(2308);
    }
}
