package managers;

import exceptions.NoElementException;
import managers.generators.IdGenerator;
import recources.Worker;

import java.time.LocalDate;
import java.util.LinkedHashMap;

public class CollectionManager {
    private static CollectionManager instance;
    private static LinkedHashMap<String, Worker> table = new LinkedHashMap<>();
    private static LocalDate date;

    private CollectionManager() {
        table = new LinkedHashMap<>();
        date = LocalDate.now();
    }

    public static synchronized CollectionManager getInstance() {
        if (instance == null) {
            instance = new CollectionManager();
        }
        return instance;
    }

    public static LocalDate getInitDate() {
        return date;
    }



    public static void add(String key, Worker worker) {
        if (table == null) {
            table = new LinkedHashMap<>();
        }
        table.put(key, worker);
        IdGenerator.add(worker.getId());
    }

    public static void remove(String key) throws NoElementException {
        if (table == null || !CollectionManager.table.containsKey(key)) {
            throw new NoElementException(key);
        } else {
            IdGenerator.remove(CollectionManager.table.get(key).getId());
            table.remove(key);
        }
    }

    public static LinkedHashMap<String, Worker> getTable() {
        return table;
    }
}
