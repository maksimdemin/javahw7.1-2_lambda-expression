import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.String.format;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        //======================== ДЗ 7.1 ====================================
//        staff.sort((o1, o2) -> o1.getSalary().equals(o2.getSalary()) ?
//                        o1.getName().compareTo(o2.getName()) :
//                        o1.getSalary().compareTo(o2.getSalary())); // сортировка по ЗП и алфавиту с помощью лямбда выражений

//        staff.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)); // сортировка по ЗП и алфавиту


        //======================== ДЗ 7.2 ====================================
//        staff.stream().filter(e -> e.getWorkStart().getYear() == 117)
//                .max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(System.out::println); // вывод максимальной ЗП тех, кто поступил на работу в 2017 году

                staff.stream().filter(e -> e.getWorkStart().getYear() == 2017)
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println); // вывод максимальной ЗП тех, кто поступил на работу в 2017 году

    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    LocalDate.parse(fragments[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"))
//                (new SimpleDateFormat("dd.MM.yyyy")).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}