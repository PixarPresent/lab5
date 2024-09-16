package managers;

import exceptions.RootException;
import filelogic.ReaderCSV;
import filelogic.WriterCSV;

import java.io.IOException;

public class FileManager {
    public static void readFromPath(String path) throws Exception {
        ReaderCSV.read(path);
    }

    public static void writeToPath(String path) throws IOException, RootException {
        WriterCSV.write(path);
    }
}
