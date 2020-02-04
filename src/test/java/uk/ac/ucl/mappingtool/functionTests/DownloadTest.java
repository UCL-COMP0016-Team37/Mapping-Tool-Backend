package uk.ac.ucl.mappingtool.functionTests;

import org.junit.Test;
import uk.ac.ucl.mappingtool.util.Delete;
import uk.ac.ucl.mappingtool.util.Download;

import java.io.IOException;

public class DownloadTest {

    public void testDownloadOrgJson() throws IOException {
        String url = "https://www.iatiregistry.org/publisher/download_list/json";
        String dir = System.getProperty("user.dir") + "/src/main/resources/static/";
        String fileName = "orgList.json";
        Download.downloadHttpUrl(url, dir, fileName);
    }

    @Test
    public void testDeleteFile() throws IOException{
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/orgList.json";
        Delete.deleteOneFile(filePath);
    }

    @Test
    public void testDeleteDir() throws IOException {
        String dirPath = System.getProperty("user.dir") + "/src/main/resources/static/";
        Delete.deleteDirFiles(dirPath);
    }
}
