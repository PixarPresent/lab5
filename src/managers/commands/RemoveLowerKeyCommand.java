package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда удаляет из коллекции все элементы, ключ которых меньше, чем заданный
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
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
