package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда выводит элемент с минимальным ID
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class ShowMinByIdCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.showMinById();
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "min_by_id";
    }

    @Override
    public String getDescription() {
        return "show element with the less ID";
    }
}
