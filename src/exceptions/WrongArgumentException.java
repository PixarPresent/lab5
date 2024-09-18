package exceptions;

import system.TextColor;

/**
 * Обеспечивает исключение, если возникла ошибка с аргументом
 *
 * @author Konstantin
 * @since 1.0
 */
public class WrongArgumentException extends Exception{
    /**
     * @param argument название аргумента, который был введен неправильно
     * @since 1.0
     */
    public WrongArgumentException(String argument){
        super(TextColor.ANSI_RED + "Something wrong with input argument: " + argument + TextColor.ANSI_RESET);
    }
}
