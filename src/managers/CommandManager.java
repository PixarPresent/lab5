package managers;

import exceptions.UnknownCommandException;
import managers.commands.*;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;


public class CommandManager {
    private static LinkedHashMap<String, BaseCommand> commandList;
    public static ArrayDeque<BaseCommand> lastSixCommand = new ArrayDeque<>();

    public CommandManager() {
        commandList = new LinkedHashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("insert", new InsertCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove_key", new RemoveCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("save", new SaveCSVCommand());
        commandList.put("execute_script", new ExecuteScriptCommand());
        commandList.put("exit", new ExitCommand());
        commandList.put("remove_greater", new RemoveLowerCommand());
        commandList.put("history", new HistoryCommand());
        commandList.put("replace_if_grater", new ReplaceIfGraterCommand());
        commandList.put("remove_lower_key ", new RemoveLowerKeyCommand());
        commandList.put("min_by_id", new ShowMinByIdCommand());
        commandList.put("count_greater_than_status ", new CountGreaterThanStatusCommand());
        commandList.put("print_unique_salary  ", new PrintUniqueSalary());
    }

    public static void startExecuting(String line) throws Exception {
        String commandName = line.split(" ")[0];
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
        }
        BaseCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
        if (!(lastSixCommand == null) && lastSixCommand.size() == 6) {
            lastSixCommand.pop();
            lastSixCommand.addLast(command);
        } else {
            assert lastSixCommand != null;
            lastSixCommand.addFirst(command);
        }

    }

    public static LinkedHashMap<String, BaseCommand> getCommandList() {
        return commandList;
    }
}
