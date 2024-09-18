package exceptions;

import system.TextColor;
/**
 * Обеспечивает исключение, если возникла ошибка при создании объекта класса Organization
 *
 * @see recources.Worker
 * @author Konstantin
 * @since 1.0
 */
public class BuildOrganizationException extends Exception{

    public BuildOrganizationException(String message){
        super(TextColor.ANSI_RED + message + TextColor.ANSI_RESET);
    }
}
