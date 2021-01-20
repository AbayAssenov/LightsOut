package com.abay.assenov.lights_out.service.impl;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.CoordinatePoint;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;
import com.abay.assenov.lights_out.service.PrinterService;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PrinterServiceImpl implements PrinterService {
    @Override
    public void printBoard(Board board) {
        System.out.println("Board : ");

        for (Integer[] row : board.getPositions()) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    @Override
    public void printDepth(Depth depth) {
        System.out.println("Depth : " + depth.getValue());
        System.out.println();
    }

    @Override
    public void printPieces(Queue<Piece> pieces) {
        System.out.println("Pieces : ");

        for (Piece piece : pieces) {
            for (String[] row : piece.getParts()) {
                for (String cell : row) {
                    System.out.print(cell + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void printCoordinatePoints(Map<Piece, CoordinatePoint> coordinatePoints) {
        System.out.println("Coordinate points : ");
        for (Map.Entry<Piece, CoordinatePoint> entry : coordinatePoints.entrySet()) {
            System.out.print(entry.getValue().getX() + "," + entry.getValue().getY() + " ");
        }
        System.out.println();
    }

    @Override
    public void printSuitableCoordinates(Map<CoordinatePoint, Double> coordinatePointsWithSuitablePercent) {

        System.out.println("Coordinate points with percentage suitable  : ");
        for (Map.Entry<CoordinatePoint, Double> entry : coordinatePointsWithSuitablePercent.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
