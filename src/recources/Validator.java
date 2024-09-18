package recources;


import exceptions.ReplayIdException;
import exceptions.WrongArgumentException;
import managers.generators.IdGenerator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Данный класс проверяет корректность каждого параметра Organization
 *
 * @author Konstantin
 * @see Worker
 * @since 1.0
 */
public class Validator {

    /**
     * Проверяет корректность ID
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если возникла проблема
     * @throws ReplayIdException      если такой ID уже зарезервирован
     */
    public static void idIsOk(String arg) throws WrongArgumentException, ReplayIdException {
        long id;
        try {
            id = Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("ID");
        }

        if (!IdGenerator.idIsUnique(id)) {
            throw new ReplayIdException(id);
        }
    }

    /**
     * Проверяет, что значение строки не null
     *
     * @param arg  аргумент строки
     * @param data какой тип данных из Organization мы проверяем
     * @throws WrongArgumentException если значение arg null
     */
    public static void inputIsNotEmpty(String arg, String data) throws WrongArgumentException {
        if (arg.isEmpty() || arg.trim().isEmpty()) {
            throw new WrongArgumentException(data);
        }
    }

    /**
     * Проверяет корректность координат по X
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Coordinates
     */
    public static void coordinateXIsOk(String arg) throws WrongArgumentException {
        try {
            Integer.parseInt(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("X");
        }
    }

    /**
     * Проверяет корректность координат по X
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Coordinates
     */
    public static void annualTurnoverIsOk(String arg) throws WrongArgumentException {
        try {
            Double.parseDouble(arg);
            if (Double.parseDouble(arg) <= 0) {
                throw new WrongArgumentException("X");
            }
        } catch (Exception e) {
            throw new WrongArgumentException("X");
        }
    }

    /**
     * Проверяет корректность координат по Y
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Coordinates
     */
    public static void coordinateYIsOk(String arg) throws WrongArgumentException {
        try {
            Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Y");
        }
    }

    /**
     * Проверяет корректность годового оборота
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если годовой оборот некорректен
     */
    public static void salaryIsOk(String arg) throws WrongArgumentException {
        try {
            long n = Long.parseLong(arg);
            if (n <= 0) {
                throw new WrongArgumentException("salary");
            }
        } catch (Exception e) {
            throw new WrongArgumentException("salary");
        }
    }

    /**
     * Проверяет корректность даты начала работы
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если число работников некорректно
     */
    public static void startDateIsOk(String arg) throws WrongArgumentException {
        try {
            LocalDate n = LocalDate.parse(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("startDate");
        }
    }

    /**
     * Проверяет корректность даты начала работы
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если число работников некорректно
     */
    public static void endDateIsOk(String arg) throws WrongArgumentException {
        try {
            if (arg.isEmpty()) {
                return;
            }
            LocalDate localDate = LocalDate.parse(arg, DateTimeFormatter.ISO_LOCAL_DATE);
            ZoneId zoneId = ZoneId.systemDefault();
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        } catch (Exception e) {
            throw new WrongArgumentException("endDate");
        }
    }

    /**
     * Проверяет корректность статуса
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если тип некорректен
     * @see Status
     */
    public static void statusIsOk(String arg) throws WrongArgumentException {
        try {
            Status.valueOf(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Status");
        }
    }

    /**
     * Проверяет корректность типа
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если тип некорректен
     * @see Status
     */
    public static void organizationTypeIsOk(String arg) throws WrongArgumentException {
        try {
            OrganizationType.valueOf(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("OrganizationType");
        }
    }

}
