package chess.domain.position;

import java.util.Arrays;

public enum File {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int coordinate;

    File(int coordinate) {
        this.coordinate = coordinate;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public static File findFile(int value) {
        return Arrays.stream(File.values())
            .filter(file -> file.coordinate == value)
            .findAny()
            .orElseThrow();
    }
}