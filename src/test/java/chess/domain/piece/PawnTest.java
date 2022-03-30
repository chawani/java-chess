package chess.domain.piece;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.position.File;
import chess.domain.position.Position;
import chess.domain.position.Rank;

public class PawnTest {

    private Pawn whitePawn;
    private Pawn blackPawn;

    @BeforeEach
    void setUp() {
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);
    }

    @Test
    @DisplayName("Pawn이 움직일 수 있는지 여부를 확인한다")
    void isWhiteMovableTest() {
        Position from = Position.valueOf(File.A, Rank.ONE);
        Position to = Position.valueOf(File.A, Rank.TWO);

        assertThat(whitePawn.isMovable(from, to)).isTrue();
    }

    @Test
    @DisplayName("Pawn이 움직일 수 있는지 여부를 확인한다")
    void isBlackMovableTest() {
        Position from = Position.valueOf(File.A, Rank.SEVEN);
        Position to = Position.valueOf(File.A, Rank.SIX);

        assertThat(blackPawn.isMovable(from, to)).isTrue();
    }

    @Test
    @DisplayName("Pawn이 움직일 수 없는 경우에 false를 반환한다.")
    void isNotMovableTest() {
        Position from = Position.valueOf(File.A, Rank.TWO);
        Position to = Position.valueOf(File.B, Rank.TWO);

        assertThat(whitePawn.isMovable(from, to)).isFalse();
    }

    @Test
    @DisplayName("초기 위치에서 Pawn이 움직일 수 있는지 여부를 확인한다.")
    void isInitialPositionWhiteMovableTest() {
        Position from = Position.valueOf(File.A, Rank.TWO);
        Position to = Position.valueOf(File.A, Rank.FOUR);

        assertThat(whitePawn.isMovable(from, to)).isTrue();
    }

    @Test
    @DisplayName("Pawn은 초기 위치가 아니면 2칸 이동 할 수 없다.")
    void isWhiteNotMovableTwoStepTest() {
        Position from = Position.valueOf(File.A, Rank.THREE);
        Position to = Position.valueOf(File.A, Rank.FIVE);

        assertThat(whitePawn.isMovable(from, to)).isFalse();
    }

    @Test
    @DisplayName("흰 색 Pawn은 대각선 위로 움직여 말을 잡을 수 있다.")
    void isWhitePawnCatchablePosition() {
        Position from = Position.valueOf(File.A, Rank.THREE);
        Position to = Position.valueOf(File.B, Rank.FOUR);

        assertThat(whitePawn.isCatchable(from, to)).isTrue();
    }

    @Test
    @DisplayName("흰 색 Pawn은 대각선 아래로 움직여 말을 잡을 수 없다.")
    void isNotWhitePawnCatchablePosition() {
        Position from = Position.valueOf(File.A, Rank.THREE);
        Position to = Position.valueOf(File.B, Rank.TWO);

        assertThat(whitePawn.isCatchable(from, to)).isFalse();
    }

    @Test
    @DisplayName("검은색 Pawn은 대각선 아래로 움직여 말을 잡을 수 있다.")
    void isBlackPawnCatchablePosition() {
        Position from = Position.valueOf(File.A, Rank.SIX);
        Position to = Position.valueOf(File.B, Rank.FIVE);

        assertThat(blackPawn.isCatchable(from, to)).isTrue();
    }

    @Test
    @DisplayName("검은색 Pawn은 대각선 위로 움직여 말을 잡을 수 없다.")
    void isBlackPawnNonCatchablePosition() {
        Position from = Position.valueOf(File.A, Rank.SIX);
        Position to = Position.valueOf(File.B, Rank.SEVEN);

        assertThat(blackPawn.isCatchable(from, to)).isFalse();
    }
}
