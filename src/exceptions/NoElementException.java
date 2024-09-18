package exceptions;

import system.TextColor;
/**
 * Обеспечивает исключение, если не существует элемента в коллекции
 *
 * @see managers.CollectionManager
 * @author Konstantin
 * @since 1.0
 */
public class NoElementException extends Exception{

    public NoElementException(String key){
        super(TextColor.ANSI_RED + "No element in collection with key: " + key + TextColor.ANSI_RESET);
    }

    public NoElementException(Long id){
        super(TextColor.ANSI_RED + "No element in collection with id: " + id + TextColor.ANSI_RESET);
    }
}
