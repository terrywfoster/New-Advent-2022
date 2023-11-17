package foster.terry.aoc2022.Day02;

public enum actionName {
    WIN("Z"),
    TIE("Y"),
    LOSE("X");

    public final String value;

    actionName(String value)
    {
        this.value = value;
    }

}
