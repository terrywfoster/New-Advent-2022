package foster.terry.aoc2022.Day02;

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
