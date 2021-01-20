package com.abay.assenov.lights_out.service;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.CoordinatePoint;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;

import java.util.Map;
import java.util.Queue;

public interface EstimateProcessorService {

    Board applyPiece(Piece piece, CoordinatePoint coordinatePoint, Board board, Depth depth);

    Double getPercentageSolve(Board board);

    Map<Piece, CoordinatePoint> estimateMostSuitableMovies(Queue<Piece> pieces, Board board, Depth depth);
}
