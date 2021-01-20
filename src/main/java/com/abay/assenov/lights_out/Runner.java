package com.abay.assenov.lights_out;

import com.abay.assenov.lights_out.model.Board;
import com.abay.assenov.lights_out.model.Depth;
import com.abay.assenov.lights_out.model.Piece;
import com.abay.assenov.lights_out.service.EstimateProcessorService;
import com.abay.assenov.lights_out.service.FileReaderService;
import com.abay.assenov.lights_out.service.ParserDataService;
import com.abay.assenov.lights_out.service.PrinterService;
import com.abay.assenov.lights_out.service.impl.EstimateProcessorServiceImpl;
import com.abay.assenov.lights_out.service.impl.FileReaderServiceImpl;
import com.abay.assenov.lights_out.service.impl.ParserDataServiceImpl;
import com.abay.assenov.lights_out.service.impl.PrinterServiceImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

import static com.abay.assenov.lights_out.constant.Constant.*;

public class Runner {

    private static ParserDataService parserDataService;
    private static FileReaderService fileReaderService;
    private static PrinterService printerService;
    private static EstimateProcessorService estimateProcessorService;

    public static void main(String[] args) {

        String pathToFolder = args.length > 0 && Objects.nonNull(args[0]) ? args[0] : DEFAULT_PATH_LIGHTS_OUT_DATA_FILES;

        initServices(); // initialize services

        handleLightsOutData(Paths.get(pathToFolder)); // handle and print result

    }

    private static void handleLightsOutData(Path pathToFolder) {
        List<Path> pathsToAllFiles = fileReaderService.getAbsolutePathAllFileInFolder(pathToFolder);

        for (Path pathToFile : pathsToAllFiles) {
            List<String> lines = fileReaderService.readLines(pathToFile);

            System.out.println(pathToFile.getFileName());

            Depth currentDepth = parserDataService.parseDepth(lines.get(DEFAULT_INDEX_DEPTH));
            Board currentBoard = parserDataService.parseBoard(lines.get(DEFAULT_INDEX_BOARD));
            Queue<Piece> currentPieceList = parserDataService.parsePiece(lines.get(DEFAULT_INDEX_PIECE));

            printerService.printDepth(currentDepth);

            printerService.printBoard(currentBoard);

            printerService.printPieces(currentPieceList);

            printerService.printCoordinatePoints(estimateProcessorService.
                    estimateMostSuitableMovies(currentPieceList, currentBoard, currentDepth));
        }
    }

    private static void initServices() {
        parserDataService = new ParserDataServiceImpl();
        fileReaderService = new FileReaderServiceImpl();
        printerService = new PrinterServiceImpl();
        estimateProcessorService = new EstimateProcessorServiceImpl();
    }
}
