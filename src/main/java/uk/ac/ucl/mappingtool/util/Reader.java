package uk.ac.ucl.mappingtool.util;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Reader {

    private static final String ENCODE = "utf-8";

    public static String readFileContent(String filePath) throws IOException {

        File inputFile = new File(filePath);

        String result = FileUtils.readFileToString(inputFile, ENCODE);

        return result;
    }
}
