package managers.commands;

import managers.Reciewer;


public class ExecuteScriptCommand implements BaseCommand {

    @Override
    public void execute(String[] args) throws Exception {
        try {
            Reciewer.executeScript(args[1]);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String getName() {
        return "execute_script file_name";
    }

    @Override
    public String getDescription() {
        return "execute script from file";
    }
}
