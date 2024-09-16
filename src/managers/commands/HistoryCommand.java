package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;


public class HistoryCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.showHistory();
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "show last 6 command";
    }
}
