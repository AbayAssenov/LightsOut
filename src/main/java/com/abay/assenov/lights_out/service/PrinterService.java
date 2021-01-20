package com.abay.assenov.lights_out.service;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.CoordinatePoint;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;

import java.util.Map;
import java.util.Queue;

public interface PrinterService {

    void printBoard(Board board);

    void printDepth(Depth depth);

    void printPieces(Queue<Piece> pieces);

    void printCoordinatePoints(Map<Piece, CoordinatePoint> coordinatePoints);

    void printSuitableCoordinates(Map<CoordinatePoint, Double> coordinatePointsWithSuitablePercent);
}
