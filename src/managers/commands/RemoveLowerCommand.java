package managers.commands;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.Reciewer;


public class RemoveLowerCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongArgumentException, BuildOrganizationException, NoElementException {
        if (args.length == 1) {
            Reciewer.removeLower();
        } else {
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "remove_grater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements with grater than the element";
    }
}
