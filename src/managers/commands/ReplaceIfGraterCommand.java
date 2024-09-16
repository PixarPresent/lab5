package managers.commands;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.Reciewer;


public class ReplaceIfGraterCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongArgumentException, BuildOrganizationException, NoElementException {
        if (args.length == 2) {
            Reciewer.replaceIfGrater(args[1]);
        } else {
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }
}
