package managers;

import filelogic.ReaderCSV;
import system.TextColor;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Данный класс отвечает за чтение командной строки
 * Обеспечивает связь между пользователем и командами (CommandManager)
 *
 * @author Konstantin
 * @see CommandManager
 * @since 1.0
 */
public class Console {
    public static String data_path = null;

    /**
     * Начните выполнять команды из InputStream.
     *
     * @param input откуда происходит чтение
     * @param path путь до файла
     */
    public void start(InputStream input, String path) {
        Scanner scanner = new Scanner(input);
        new CommandManager();
        try {
            System.out.println("Downloading data from file...");
            data_path = path;
            ReaderCSV.read(data_path);
            System.out.println(TextColor.ANSI_BLUE + "Everything is OK." + TextColor.ANSI_RESET);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error while reading file\n" + path);
            System.exit(0);
        }

        System.out.println("Welcome to app!");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();
            if (!command.isEmpty()){
                try {
                    CommandManager.startExecuting(command);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
