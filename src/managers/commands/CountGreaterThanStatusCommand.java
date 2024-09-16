package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

public class CountGreaterThanStatusCommand implements BaseCommand{
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 2) {
            Reciewer.countGreaterThanStatus(args[1]);
        } else{
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "count_greater_than_status";
    }

    @Override
    public String getDescription() {
        return "display the number of elements whose status field value is greater than a given one";
    }
}
