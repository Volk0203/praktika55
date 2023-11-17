import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите дату (в формате dd.MM.yyyy): ");
            String inputDate = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = dateFormat.parse(inputDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 45);
            Date newDate = calendar.getTime();
            String newDateStr = dateFormat.format(newDate);
            System.out.println("Дата после добавления 45 дней: " + newDateStr);
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            newDate = calendar.getTime();
            newDateStr = dateFormat.format(newDate);
            System.out.println("Дата после сдвига на начало года: " + newDateStr);
            int workingDaysToAdd = 10;
            int addedWorkingDays = 0;
            while (addedWorkingDays < workingDaysToAdd) {
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                        && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    addedWorkingDays++;
                }
            }
            newDate = calendar.getTime();
            newDateStr = dateFormat.format(newDate);
            System.out.println("Дата после добавления 10 рабочих дней: " + newDateStr);
            System.out.print("Введите вторую дату (в формате dd.MM.yyyy): ");
            String secondDateStr = scanner.nextLine();
            Date secondDate = dateFormat.parse(secondDateStr);
            int workingDays = 0;
            calendar.setTime(date);
            while (!calendar.getTime().after(secondDate)) {
                if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
                        && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    workingDays++;
                }
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            System.out.println("Количество рабочих дней между двумя датами: " + workingDays);
        } catch (ParseException e) {
            System.out.println("Ошибка ввода даты");
        }
    }
}
