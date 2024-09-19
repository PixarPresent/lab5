package managers;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.RootException;
import exceptions.WrongArgumentException;
import managers.commands.BaseCommand;
import managers.generators.WorkerGenerator;
import recources.*;
import recources.comparators.WorkerComparator;
import system.TextColor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Reciewer {
    private static Stack<File> st = new Stack<>();

    public static void updateById(String arg) throws WrongArgumentException, BuildOrganizationException, NoElementException {
        System.out.println("Start executing command...");

        boolean elementInCollection = false;
        int id = Integer.parseInt(arg);

        for (String k : CollectionManager.getTable().keySet()) {
            if (CollectionManager.getTable().get(k).getId() == id) {
                System.out.println(TextColor.ANSI_BLUE + "Updating element with id " + id + TextColor.ANSI_RESET);
                elementInCollection = true;

                Worker worker = WorkerGenerator.createWorker();
                worker.setId(id);
                CollectionManager.remove(k);
                CollectionManager.add(k, worker);

                System.out.println(TextColor.ANSI_BLUE + "Element was updated" + TextColor.ANSI_RESET);
            }
        }
        if (!elementInCollection) {
            throw new NoElementException(String.valueOf(id));
        }
    }

    public static void updateById(String arg, Worker worker) throws NoElementException {
        System.out.println("Start executing command...");

        boolean elementInCollection = false;
        int id = Integer.parseInt(arg);

        for (String k : CollectionManager.getTable().keySet()) {
            if (CollectionManager.getTable().get(k).getId() == id) {
                System.out.println(TextColor.ANSI_BLUE + "Updating element with id " + id + TextColor.ANSI_RESET);
                elementInCollection = true;

                worker.setId(id);
                worker.setCreationDate(ZonedDateTime.now());
                CollectionManager.remove(k);
                CollectionManager.add(k, worker);

                System.out.println(TextColor.ANSI_BLUE + "Element was updated" + TextColor.ANSI_RESET);
            }
        }
        if (!elementInCollection) {
            throw new NoElementException(String.valueOf(id));
        }
    }


    public static void showMinById() {
        Worker worker = null;
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        for (String key : table.keySet()) {
            if (worker == null) {
                worker = table.get(key);
            } else if (worker.compareTo(table.get(key)) > 0) {
                worker = table.get(key);
            }
        }
        System.out.println(worker);
    }

    public static void countGreaterThanStatus(String arg) throws WrongArgumentException {
        Validator.statusIsOk(arg);
        Status status = Status.valueOf(arg);
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        int count = 0;
        for (String key : table.keySet()) {
            if (status.compareTo(table.get(key).getStatus()) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void showCommand() {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        for (String x : table.keySet()) {
            System.out.println("Key:" + x + "\t" + table.get(x));
        }
        if (table.isEmpty()) {
            System.out.println(CollectionManager.getTable().getClass().getName() + " is empty");
        }
    }

    public static void saveData() throws IOException, RootException {
        FileManager.writeToPath(Console.data_path);
        System.out.println(TextColor.ANSI_BLUE + "Data was saved" + TextColor.ANSI_RESET);
    }


    public static void replaceIfGrater(String key) throws WrongArgumentException, BuildOrganizationException, NoElementException {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        WorkerComparator c1 = new WorkerComparator();
        if (table.containsKey(key)) {
            Worker worker = WorkerGenerator.createWorker();
            if (c1.compare(worker, table.get(key)) > 0) {
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
            }
        } else {
            System.out.println("No element with key " + key);
        }
    }


    public static void replaceIfGrater(String key, Worker worker) throws NoElementException {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        WorkerComparator c1 = new WorkerComparator();
        if (table.containsKey(key)) {
            if (c1.compare(worker, table.get(key)) > 0) {
                CollectionManager.remove(key);
                CollectionManager.add(key, worker);
            }
        } else {
            System.out.println("No element with key " + key);
        }
    }


    public static void removeLower() throws WrongArgumentException, BuildOrganizationException, NoElementException {
        Worker worker = WorkerGenerator.createWorker();
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();


        WorkerComparator c1 = new WorkerComparator();
        ArrayList<String> keySet = new ArrayList<>();

        for (String key : table.keySet()) {
            if (c1.compare(worker, table.get(key)) < 0) {
                keySet.add(key);
            }
        }
        int k = keySet.size();
        for (String key : keySet) {
            CollectionManager.remove(key);
        }
        if (k == CollectionManager.getTable().size()) {
            System.out.println("Nothing was changed");
        }
    }

    public static void removeLower(Worker worker) throws NoElementException {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();

        WorkerComparator c1 = new WorkerComparator();
        ArrayList<String> keySet = new ArrayList<>();

        for (String key : table.keySet()) {
            if (c1.compare(worker, table.get(key)) < 0) {
                keySet.add(key);
            }
        }
        int k = keySet.size();
        for (String key : keySet) {
            CollectionManager.remove(key);
        }
        if (k == CollectionManager.getTable().size()) {
            System.out.println("Nothing was changed");
        }
    }

    public static void removeLowerKey(String key) throws WrongArgumentException, BuildOrganizationException, NoElementException {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        ArrayList<String> keySet = new ArrayList<>();

        for (String k1 : table.keySet()) {
            if (key.length() > k1.length()) {
                keySet.add(key);
            }
        }
        int k = keySet.size();
        for (String k2 : keySet) {
            CollectionManager.remove(k2);
        }
        if (k == CollectionManager.getTable().size()) {
            System.out.println("Nothing was changed");
        }
    }


    public static void removeByKey(String key) {
        System.out.println(TextColor.ANSI_BLUE + "Start executing command..." + TextColor.ANSI_RESET);
        try {
            CollectionManager.remove(key);
            System.out.println(TextColor.ANSI_BLUE + "Element was removed" + TextColor.ANSI_RESET);
        } catch (NoElementException e) {
            System.out.println(TextColor.ANSI_RED + e.getMessage() + TextColor.ANSI_RESET);
            System.out.println("Program was returned to safe state");
        }
    }

    public static void printUniqueSalary() {
        LinkedHashMap<String, Worker> table = CollectionManager.getTable();
        Set<Long> salarySet = new HashSet<>();

        for (String key : table.keySet()) {
            salarySet.add(table.get(key).getSalary());
        }
        for (long salary : salarySet) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }

    public static void insertNew(String key) {
        try {
            if (CollectionManager.getTable().containsKey(key)) {
                System.out.println("This key is already used");
                return;
            }
            Worker worker = WorkerGenerator.createWorker();
            CollectionManager.add(key, worker);
            System.out.println(TextColor.ANSI_BLUE + "Element was added" + TextColor.ANSI_RESET);
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
        } catch (BuildOrganizationException e) {
            System.out.println(e.getMessage());
            System.out.println("Program was returned to safe state");
        }
    }


    public static void insertNew(String key, Worker worker) {
        if (CollectionManager.getTable().containsKey(key)) {
            System.out.println("This key is already used");
            return;
        }
        CollectionManager.add(key, worker);
        System.out.println(TextColor.ANSI_BLUE + "Element was added" + TextColor.ANSI_RESET);
    }


    public static void showInfo() {
        System.out.println("Data type - " + CollectionManager.getTable().getClass().getName());
        System.out.println("Count of organization - " + CollectionManager.getTable().keySet().size());
        System.out.println("Init date - " + CollectionManager.getInitDate());
    }

    public static void showHistory() {
        String[] sp = new String[6];
        int n = 0;
        for (BaseCommand command : CommandManager.lastSixCommand) {
            sp[n] = command.getName();
            n += 1;
        }
        for (int i = 0; i < 6; i++) {
            if (!(sp[i] == null)) {
                System.out.println("-" + sp[i]);
            }
        }
    }

    public static void showHelp() {
        LinkedHashMap<String, BaseCommand> commandList = CommandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            System.out.println(TextColor.ANSI_BLUE + command.getName() + TextColor.ANSI_RESET + " - " + command.getDescription());
        }
    }

    public static void executeScript(String path) throws Exception {
        File file = new File(path);
        if (!file.canRead()) {
            System.out.println("You do not have enough rights to read the file");
            return;
        }
        if (st.isEmpty()) {
            st.add(file);
        }

        st.add(file);
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        String[] sp = new String[10];
        while ((line = br.readLine()) != null) {
            String command = line.split(" ")[0];
            if (command.equals("insert") || command.contains("remove_lower") || command.contains("replace_if_grater")
                    || command.contains("remove_grater") || command.contains("update")) {
                String key = line.split(" ")[1];
                for (int n = 0; n < 9; n++) {
                    if ((line = br.readLine()) != null) {
                        sp[n] = line;
                    }
                }
                Validator.inputIsNotEmpty(sp[0], "Name");
                Validator.coordinateXIsOk(sp[1]);
                Validator.coordinateYIsOk(sp[2]);
                Validator.startDateIsOk(sp[3]);
                Validator.salaryIsOk(sp[4]);
                Validator.endDateIsOk(sp[5]);
                Validator.statusIsOk(sp[6]);
                Validator.annualTurnoverIsOk(sp[7]);
                Validator.organizationTypeIsOk(sp[8]);

                Worker worker = new Worker();
                worker.setName(sp[0]);
                Coordinates coordinates = new Coordinates(Long.parseLong(sp[1]), Integer.parseInt(sp[2]));
                worker.setCoordinates(coordinates);
                worker.setCreationDate(ZonedDateTime.now());
                worker.setStartDate(LocalDate.parse(sp[3]));
                worker.setSalary(Long.parseLong(sp[4]));

                LocalDate localDate = LocalDate.parse(sp[5], DateTimeFormatter.ISO_LOCAL_DATE);
                ZoneId zoneId = ZoneId.systemDefault();
                worker.setEndDate(localDate.atStartOfDay(zoneId));

                worker.setStatus(Status.valueOf(sp[6]));

                Organization og = new Organization();
                og.setAnnualTurnover(Double.parseDouble(sp[7]));
                og.setType(OrganizationType.valueOf(sp[8]));
                worker.setOrganization(og);

                Reciewer.insertNew(key, worker);
                switch (command) {
                    case "insert":
                        CollectionManager.add(key, worker);
                        break;
                    case "remove_lower":
                        Reciewer.removeLower(worker);
                        break;
                    case "replace_if_grater":
                        Reciewer.replaceIfGrater(key, worker);
                        break;
                    case "remove_lower_key":
                        Reciewer.removeLowerKey(key);
                        break;
                    case "update":
                        Reciewer.updateById(key, worker);
                        break;
                }

            } else {
                if (line.contains("execute_script")) {
                    File file_new = new File(line.split(" ")[1]);
                    if (!file_new.canRead()) {
                        System.out.println("You do not have enough rights to read the file");
                    }
                    if (st.contains(file_new)) {
                        System.out.println("Recursion to file " + file.getName() + " was skipped");
                    } else {
                        try {
                            CommandManager.startExecuting(line);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                } else {
                    try {
                        CommandManager.startExecuting(line);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        st.pop();
    }


    public static void clearMap() {
        CollectionManager.getTable().clear();
        System.out.println("Map is clear");
    }

}
