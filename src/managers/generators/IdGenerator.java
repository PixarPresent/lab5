package managers.generators;

import java.util.ArrayList;


public class IdGenerator {
    private static IdGenerator instance;
    private static final Integer min = 1000000;
    private static final Integer max = 10000000;
    private static ArrayList<Integer> IdList = new ArrayList<>();


    private IdGenerator() {
        IdList = new ArrayList<>();
    }
    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGenerator();
        }
        return instance;
    }

    public static int generateId() {
        int id = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        while (IdList.contains(id)) {
            id = (int) Math.floor(Math.random() * (max - min + 1)) + min;
        }
        IdList.add(id);
        return id;
    }


    public static boolean idIsUnique(long id) {
        if (IdList.contains(id)) {
            return false;
        }
        return true;
    }


    public static void add(int id) {
        IdList.add(id);
    }

    public static void remove(long id) {
        IdList.remove(id);
    }
    public static void clear(){
        IdList.clear();
    }
}
