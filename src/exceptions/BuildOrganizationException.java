package exceptions;

import system.TextColor;


public class BuildOrganizationException extends Exception{

    public BuildOrganizationException(String message){
        super(TextColor.ANSI_RED + message + TextColor.ANSI_RESET);
    }
}
