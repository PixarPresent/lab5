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
        return "remove_lower_key {key}";
    }

    @Override
    public String getDescription() {
        return "remove all items from the collection whose key is less than the specified one";
    }
}
