package managers.commands;

import exceptions.WrongArgumentException;
import managers.Reciewer;

public class PrintUniqueSalary implements BaseCommand{
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            Reciewer.printUniqueSalary();
        } else {
            throw new WrongArgumentException("command parameter");
        }
    }

    @Override
    public String getName() {
        return "print_unique_salary";
    }

    @Override
    public String getDescription() {
        return "print the unique values of the salary field of all elements in the collection";
    }
}
