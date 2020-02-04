package uk.ac.ucl.mappingtool.util;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Download {

    public static void downloadHttpUrl(String url, String dir, String fileName) throws IOException {
        URL httpUrl = new URL(url);
        File dirFile = new File(dir);

        if(!dirFile.exists()){
            dirFile.mkdirs();
        }

        FileUtils.copyURLToFile(httpUrl, new File(dir + fileName));
    }
}
