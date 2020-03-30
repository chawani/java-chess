package chess.domain.piece;

import chess.domain.Position;
import chess.domain.move.MoveType;

public interface PieceAbility {
    boolean isMovable(MoveType moveType);

    String pieceName();

    boolean isEqualPosition(Position position);

    double getScore();
}