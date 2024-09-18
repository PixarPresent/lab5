package filelogic;

import exceptions.RootException;
import managers.CollectionManager;
import recources.Worker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Данный класс выполняет запись данных, которые хранятся в формате XML
 *
 * @author Konstantin
 * @since 1.0
 */
public class WriterCSV{
    /**
     * Записывает данные коллекции в файл
     *
     * @see CollectionManager
     * @param path путь до файла
     */
    public static void write(String path) throws IOException, RootException {
        File file = new File(path);

        if (!file.canWrite()){
            throw new RootException("You do not have enough rights to write to the file");
        }
        StringBuilder csv = new StringBuilder();
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();

        for (String key : table.keySet()) {
            csv.append(key).append(";").append(table.get(key).toCSV()).append("\n");
        }

        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(Arrays.toString(csv.toString().getBytes()));
        fileWriter.close();
    }

}
