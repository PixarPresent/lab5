package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда выводит список всех команд
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.showCommand();
        } else{
            throw new WrongArgumentException("command parameter");
        }

    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show data";
    }
}
