package uk.ac.ucl.mappingtool.util;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Download {

    private static String rootDir = System.getProperty("user.dir");

    public static void downloadHttpUrl(String url, String dir, String fileName) throws IOException {
        String dirPath = rootDir + dir;

        URL httpUrl = new URL(url);
        File dirFile = new File(dirPath);

        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

        FileUtils.copyURLToFile(httpUrl, new File(dirPath + fileName));
    }
}
