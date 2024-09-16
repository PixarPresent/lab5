package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;


public class ClearCommand implements BaseCommand {

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.clearMap();
        } else{
            throw new WrongArgumentException("command parameter");
        }

    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear data from table";
    }
}
