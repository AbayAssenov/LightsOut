package com.abay.assenov.lights_out.service;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.CoordinatePoint;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;
import com.abay.assenov.lights_out.service.impl.EstimateProcessorServiceImpl;
import com.abay.assenov.lights_out.service.impl.FileReaderServiceImpl;
import com.abay.assenov.lights_out.service.impl.ParserDataServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static com.abay.assenov.lights_out.constant.Constant.*;


public class EstimateProcessorServiceTest extends TestCase {

    private EstimateProcessorService estimateService;
    private FileReaderService fileReaderService;
    private ParserDataService parserDataService;
    private Path testFilePath;
    Map<Piece, CoordinatePoint> testDataResult;
    Depth testDepthData;
    Board testBoardData;
    Queue<Piece> testPiecesData;

    @Before
    public void test_init_data() {
        estimateService = new EstimateProcessorServiceImpl();
        fileReaderService = new FileReaderServiceImpl();
        parserDataService = new ParserDataServiceImpl();
        testFilePath = Paths.get("src", "main", "resources", "test_data", "00.txt");
        testDataResult = new LinkedHashMap<>();

        List<String> dataLines = fileReaderService.readLines(testFilePath);
        testDepthData = parserDataService.parseDepth(dataLines.get(DEFAULT_INDEX_DEPTH));
        testBoardData = parserDataService.parseBoard(dataLines.get(DEFAULT_INDEX_BOARD));
        testPiecesData = parserDataService.parsePiece(dataLines.get(DEFAULT_INDEX_PIECE));

        testDataResult.put(testPiecesData.poll(), new CoordinatePoint(0, 1));
        testDataResult.put(testPiecesData.poll(), new CoordinatePoint(0, 2));
        testDataResult.put(testPiecesData.poll(), new CoordinatePoint(1, 0));
    }

    @Test
    public void estimateMostSuitableMovies() {

        Map<Piece, CoordinatePoint> result = estimateService.estimateMostSuitableMovies(testPiecesData
                , testBoardData
                , testDepthData);


        assertTrue(areEqual(result, testDataResult));
        throw new IllegalArgumentException();
    }

    private boolean areEqual(Map<Piece, CoordinatePoint> first, Map<Piece, CoordinatePoint> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
    }
}
