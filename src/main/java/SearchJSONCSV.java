import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.nio.file.Files;

public class SearchJSONCSV {
    String path = "D:\\Users\\Slava\\Downloads\\stations-data\\data";

    ArrayList<String> name = new ArrayList<String>();

    SearchJSONCSV() {
        search();
    }

    void search() {
        File folder = new File(path);
        File[] files = folder.listFiles();
        ArrayList<String> sfile = new ArrayList<String>();

        stree(folder, sfile);
        name.addAll(sfile);
        int i = 0;
    }

    void stree(File folder, ArrayList sf) {
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                sf.add(file.getPath());
            } else {
                File foldernew = new File(file.getPath());
                stree(foldernew ,sf);
            }
        }
    }
}


