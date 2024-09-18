package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда удаляет из коллекции элемент по ключу
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class RemoveCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongArgumentException {
        if (args.length == 2) {
            Reciewer.removeByKey(args[1]);
        } else {
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "remove_key null";
    }

    @Override
    public String getDescription() {
        return "remove_key element by key";
    }
}
