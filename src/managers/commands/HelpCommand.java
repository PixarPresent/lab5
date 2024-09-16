package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

public class HelpCommand implements BaseCommand{
    @Override
    public void execute(String[] args) throws Exception{
        if (args.length == 1) {
            Reciewer.showHelp();
        } else{
            throw new WrongArgumentException("command parameter");
        }


    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "use this command to see information";
    }
}
