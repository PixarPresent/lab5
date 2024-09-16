package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;


public class RemoveLowerKeyCommand implements BaseCommand{
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 2) {
            Reciewer.removeLowerKey(args[1]);
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
