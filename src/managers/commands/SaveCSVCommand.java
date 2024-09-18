package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

/**
 * Данная команда сохраняет коллекцию в формате XML
 *
 * @author Konstantin
 * @see BaseCommand
 * @since 1.0
 */
public class SaveCSVCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.saveData();
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }


    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save data to XML file (path)";
    }
}
