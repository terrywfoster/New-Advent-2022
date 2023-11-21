import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import foster.terry.aoc2022.Day05;
import org.junit.Test;
import org.assertj.core.api.Assertions;

public class Day05Test {
    @Test
    public void part1() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day05/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day05/PuzzleInput.txt"))
                        .toURI()));

        final Day05 part1Test = new Day05(testInput);
        final Day05 part1Puzzle = new Day05(puzzleInput);

        Assertions.assertThat(part1Test.solution(9000)).isEqualTo("CMZ");
        Assertions.assertThat(part1Puzzle.solution(9000)).isEqualTo("VPCDMSLWJ");
    }
    @Test
    public void part2() throws IOException, URISyntaxException {
        final var testInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day05/TestInput.txt"))
                        .toURI()));
        final var puzzleInput = Files.readAllLines(Paths.get(
                Objects.requireNonNull(getClass().getClassLoader().getResource("Day05/PuzzleInput.txt"))
                        .toURI()));

        final Day05 part2Test = new Day05(testInput);
        final Day05 part2Puzzle = new Day05(puzzleInput);

        Assertions.assertThat(part2Test.solution(9001)).isEqualTo("MCD");
        Assertions.assertThat(part2Puzzle.solution(9001)).isEqualTo("TPWCGNCCG");
    }
}
