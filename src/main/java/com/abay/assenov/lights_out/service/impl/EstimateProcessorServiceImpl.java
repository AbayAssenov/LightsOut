package com.abay.assenov.lights_out.service.impl;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.CoordinatePoint;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;
import com.abay.assenov.lights_out.service.EstimateProcessorService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

import static com.abay.assenov.lights_out.constant.Constant.MAX_SUITABLE_PERCENT;
import static com.abay.assenov.lights_out.constant.Constant.PIECE_PART_X;

public class EstimateProcessorServiceImpl implements EstimateProcessorService {

    @Override
    public Board applyPiece(Piece piece, CoordinatePoint coordinatePoint, Board board, Depth depth) {
        Board resultBoard = cloneBoard(board);

        for (int i = 0; i < piece.getParts().length; i++) {
            for (int j = 0; j < piece.getParts()[i].length; j++) {

                final int CURRENT_X_COORDINATE = coordinatePoint.getX() + j;
                final int CURRENT_Y_COORDINATE = coordinatePoint.getY() + i;

                if (Objects.equals(piece.getParts()[i][j], PIECE_PART_X)) {
                    resultBoard.getPositions()[CURRENT_Y_COORDINATE][CURRENT_X_COORDINATE]
                            = getIncrementPositionValue(board.getPositions()[CURRENT_Y_COORDINATE][CURRENT_X_COORDINATE], depth);
                }
            }
        }
        return resultBoard;
    }

    @Override
    public Double getPercentageSolve(Board board) {
        return Math.floor((100.0 / (board.getPositions().length * board.getPositions()[0].length)) * zeroCellCount(board));
    }

    @Override
    public Map<Piece, CoordinatePoint> estimateMostSuitableMovies(Queue<Piece> pieces, Board board, Depth depth) {

        Map<Piece, CoordinatePoint> result = new LinkedHashMap<>();
        recursiveEstimateMoves(pieces, board, depth, result);

        return result;
    }

    boolean found = false;

    private void recursiveEstimateMoves(Queue<Piece> pieces, Board board, Depth depth, Map<Piece, CoordinatePoint> coordinatePoints) {
        if (!pieces.isEmpty()) {
            Piece piece = pieces.poll();
            final int MAX_Y_STEP = board.getPositions().length - piece.getParts().length;
            final int MAX_X_STEP = board.getPositions()[0].length - piece.getParts()[0].length;

            for (int i = 0; i <= MAX_Y_STEP; i++) {
                for (int j = 0; j <= MAX_X_STEP; j++) {
                    Board tempBoard;
                    CoordinatePoint currentCoordinatePoint = new CoordinatePoint(j, i);
                    tempBoard = applyPiece(piece, currentCoordinatePoint, board, depth);
                    Double percentage = getPercentageSolve(tempBoard);

                    if (!found)
                        coordinatePoints.put(piece, currentCoordinatePoint);

                    if (percentage.equals(MAX_SUITABLE_PERCENT)) {
                        found = true;
                        return;
                    } else {
                        recursiveEstimateMoves(pieces, tempBoard, depth, coordinatePoints);
                    }
                }
            }

            pieces.add(piece);
        }
    }

    private Integer getIncrementPositionValue(Integer value, Depth depth) {
        return Objects.equals(++value, depth.getValue()) ? 0 : value;
    }

    private int zeroCellCount(Board board) {
        int count = 0;
        for (Integer[] row : board.getPositions()) {
            for (Integer cell : row) {
                if (Objects.equals(cell, 0)) count++;
            }
        }
        return count;
    }

    private Board cloneBoard(Board board) {
        Integer[][] clonePositions = new Integer[board.getPositions().length][];

        for (int i = 0; i < board.getPositions().length; i++) {
            Integer[] cloneRow = new Integer[board.getPositions()[i].length];
            System.arraycopy(board.getPositions()[i], 0, cloneRow, 0, board.getPositions()[i].length);
            clonePositions[i] = cloneRow;
        }

        return new Board(clonePositions);
    }
}
