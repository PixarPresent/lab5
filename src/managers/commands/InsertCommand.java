package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;
import system.TextColor;

/**
 * Данная команда добавляет новый элемент по ключу
 *
 * @author Konstantin
 * @see BaseCommand
 * @see recources.Worker
 * @since 1.0
 */
public class InsertCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongArgumentException {
        System.out.println(TextColor.ANSI_BLUE + "Start executing command..." + TextColor.ANSI_RESET);
        if (args.length == 2) {
            Reciewer.insertNew(args[1]);
        } else throw new WrongArgumentException("KEY");
    }

    @Override
    public String getName() {
        return "insert {element}";
    }

    @Override
    public String getDescription() {
        return "insert new element";
    }
}
