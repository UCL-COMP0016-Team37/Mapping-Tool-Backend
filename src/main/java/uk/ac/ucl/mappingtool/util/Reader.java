package uk.ac.ucl.mappingtool.util;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Reader {

    private static final String ENCODE = "utf-8";
    private static String rootDir = System.getProperty("user.dir");

    public static String readFileContent(String filePath) throws IOException {

        File inputFile = new File(rootDir + filePath);

        String result = FileUtils.readFileToString(inputFile, ENCODE);

        return result;
    }
}
