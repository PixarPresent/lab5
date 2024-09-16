package system;

import managers.Console;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\kosty\\IdeaProjects\\project_lab_5\\src\\system\\data.csv";
        if (path == null){
            System.out.println(TextColor.ANSI_RED + "Something wrong (no environment variable)" + TextColor.ANSI_RESET);
        }
        else {
            File file = new File(path);
            String[] pathLink = path.split("\\.");
            if (file.canRead() && file.canWrite() && pathLink[pathLink.length - 1].equals("csv")){
                Console console = new Console();
                console.start(System.in, path);
            }
            else if (!file.canRead() || !file.canWrite()){
                System.out.println(TextColor.ANSI_RED + "You do not have enough root" + TextColor.ANSI_RESET);
            } else {
                System.out.println(TextColor.ANSI_RED + "Something wrong with file" + TextColor.ANSI_RESET);
            }
        }
    }
}