package com.abay.assenov.lights_out.service.impl;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;
import com.abay.assenov.lights_out.service.ParserDataService;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static com.abay.assenov.lights_out.constant.Constant.DEFAULT_PIECE_SPLITTER;
import static com.abay.assenov.lights_out.constant.Constant.DEFAULT_ROW_SPLITTER;

public class ParserDataServiceImpl implements ParserDataService {

    @Override
    public Board parseBoard(String data) {
        String[] splitedRows = data.trim().split(DEFAULT_ROW_SPLITTER);
        Board board = new Board(new Integer[splitedRows.length][]);

        for (int j = 0; j < splitedRows.length; j++) {
            Integer[] row = new Integer[splitedRows[j].length()];
            for (int i = 0; i < splitedRows[j].length(); i++) {
                row[i] = Integer.parseInt("" + splitedRows[j].charAt(i));
            }
            board.getPositions()[j] = row;
        }

        return board;
    }

    @Override
    public Depth parseDepth(String data) {
        return new Depth(Integer.parseInt(data.trim()));
    }

    @Override
    public Queue<Piece> parsePiece(String data) {
        Queue<Piece> pieceList = new ArrayDeque<>();

        String[] splitRows = data.trim().split(DEFAULT_PIECE_SPLITTER);
        for (String row : splitRows) {

            String[] splitRowsPiece = row.trim().split(DEFAULT_ROW_SPLITTER);

            Piece piece = new Piece(new String[splitRowsPiece.length][]);

            for (int j = 0; j < splitRowsPiece.length; j++) {
                String[] rowPiece = new String[splitRowsPiece[j].length()];
                for (int i = 0; i < splitRowsPiece[j].length(); i++) {
                    rowPiece[i] = "" + splitRowsPiece[j].charAt(i);
                }
                piece.getParts()[j] = rowPiece;
            }
            pieceList.add(piece);
        }

        return pieceList;
    }
}
