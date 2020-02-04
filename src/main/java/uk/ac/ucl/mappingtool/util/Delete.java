package uk.ac.ucl.mappingtool.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Delete {

    private static String rootDir = System.getProperty("user.dir");

    /**
     * Should delete the file with the specified class
     * @param filePath
     */
    public static void deleteOneFile(String filePath) throws IOException {
        FileUtils.deleteQuietly(new File(rootDir + filePath));
    }

    public static void deleteDirFiles(String dirPath) throws IOException {
        FileUtils.deleteDirectory(new File(rootDir + dirPath));
    }
}
