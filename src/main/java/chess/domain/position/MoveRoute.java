package chess.domain.position;

import chess.controller.dto.request.CommandRequestDTO;
import chess.domain.piece.type.Direction;
import chess.domain.player.type.TeamColor;

public class MoveRoute {
    private final Position startPosition;
    private final Position destination;

    public MoveRoute(String startPositionInput, String destinationInput) {
        startPosition = Position.of(startPositionInput);
        destination = Position.of(destinationInput);
    }

    public MoveRoute(CommandRequestDTO commandRequestDTO) {
        startPosition = Position.of(commandRequestDTO.getStartPositionInput());
        destination = Position.of(commandRequestDTO.getDestinationInput());
    }

    public Position startPosition() {
        return startPosition;
    }

    public Position destination() {
        return destination;
    }

    public Direction direction() {
        return startPosition.calculateDirection(destination);
    }

    public Position nextPositionOfStartPosition() {
        return startPosition.move(direction());
    }

    public boolean isDestination(Position position) {
        return position.equals(destination);
    }

    public boolean isRankForwardedBy(int rankDiff) {
        return startPosition.isRankForwardedBy(destination, rankDiff);
    }

    public boolean isStartPositionFirstPawnPosition(TeamColor teamColor) {
        return startPosition.isFirstPawnPosition(teamColor);
    }
}