package managers.commands;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда удаляет из коллекции все элементы, превышающие заданный
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
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
        return "remove_greater {key}";
    }

    @Override
    public String getDescription() {
        return "remove elements with grater than the element";
    }
}
