package managers.commands;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда заменяет значение по ключу, если новое значение больше старого
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class ReplaceIfGreaterCommand implements BaseCommand {
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
        return "replace_if_greater {key}";
    }

    @Override
    public String getDescription() {
        return "update element by key if new bigger than element in collection with the same key";
    }
}
