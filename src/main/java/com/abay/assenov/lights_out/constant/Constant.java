package com.abay.assenov.lights_out.constant;

public class Constant {
    private Constant() {
    }

    public static final String PIECE_PART_POINT = "."; // ‘.’ means no increment
    public static final String PIECE_PART_X = "X"; // 'X’means increment by 1
    public static final String DEFAULT_PATH_LIGHTS_OUT_DATA_FILES = "/home/abay/SOME_SOURCE/lights_out_github/LightsOut/src/main/resources/test_data/01.txt"; // path to test data files
    public static final Integer DEFAULT_INDEX_DEPTH = 0;
    public static final Integer DEFAULT_INDEX_BOARD = 1;
    public static final Integer DEFAULT_INDEX_PIECE = 2;
    public static final String DEFAULT_ROW_SPLITTER = ",";
    public static final String DEFAULT_PIECE_SPLITTER = " ";
    public static final Double MAX_SUITABLE_PERCENT = 100.0;

}
