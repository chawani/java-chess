package chess.domain.game.state;

import chess.domain.Board;
import chess.domain.Position;

public class End implements GameState {

    @Override
    public GameState movePiece(Board board, Position fromPosition, Position toPosition) {
        return null;
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public boolean isWaiting() {
        return false;
    }
}
