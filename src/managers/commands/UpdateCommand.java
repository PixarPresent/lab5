package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда обновляет элемент коллекции по ID
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class UpdateCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 2) {
            Reciewer.updateById(args[1]);
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "update id {element}";
    }

    @Override
    public String getDescription() {
        return "update element";
    }
}
