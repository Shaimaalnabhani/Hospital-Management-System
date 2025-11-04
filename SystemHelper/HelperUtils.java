package SystemHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

public class HelperUtils {
    public static boolean isNull(Object obj) {
        return obj == null;
    }
    public static boolean isNull(String str) {
        return (str == null || str.isEmpty());
    }
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }
    public static boolean isNotNull(String str) {
        return (str != null && !str.isEmpty());
    }
    public static boolean isValidString(String str) {
        return isNotNull(str);
    }
    public static boolean isValidString(String str, int minLength) {
        return isNotNull(str) && str.length() >= minLength;
    }
    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isNotNull(str) && str.length() >= minLength && str.length() <= maxLength;
    }
    public static boolean isValidString(String str, String regex) {
        return isNotNull(str) && Pattern.matches(regex, str.trim());
    }
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        int randomNum = new Random().nextInt(100000);
        return prefix + "-" + randomNum;
    }

    public static String generateId(String prefix, int length) {
        String randomNum = String.valueOf(Math.abs(new Random().nextInt()));
        if (randomNum.length() > length) {
            randomNum = randomNum.substring(0, length);
        }
        return prefix + "-" + randomNum;
    }

    public static String generateId(String prefix, String suffix) {
        int randomNum = new Random().nextInt(100000);
        return prefix + "-" + randomNum + "-" + suffix;
    }
    public static boolean isValidDate(Date date) {
        return isNotNull(date);
    }

    public static boolean isValidDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            sdf.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidDate(Date date, Date minDate, Date maxDate) {
        if (isNull(date)) return false;
        return !date.before(minDate) && !date.after(maxDate);
    }

    public static boolean isFutureDate(Date date) {
        if (isNull(date)) return false;
        return date.after(new Date());
    }

    public static boolean isPastDate(Date date) {
        if (isNull(date)) return false;
        return date.before(new Date());
    }

    public static boolean isToday(Date date) {
        if (isNull(date)) return false;
        LocalDate given = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        return given.equals(today);
    }
    public static String formatDate(LocalDate date) {
        if (isNull(date)) return "N/A";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        return date.format(formatter);
    }

    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (isNull(dateOfBirth)) return false;
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return isValidAge(age);
    }
}
