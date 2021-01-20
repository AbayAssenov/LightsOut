package com.abay.assenov.lights_out.service;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;

import java.util.Queue;

public interface ParserDataService {

    Board parseBoard(String data);

    Depth parseDepth(String data);

    Queue<Piece> parsePiece(String data);
}
