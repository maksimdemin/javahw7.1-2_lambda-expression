import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employee
{
    private String name;
    private Integer salary;
    private Date workStart;
//    private LocalDate workStart;

    public Employee(String name, Integer salary, Date workStart)
//    Employee(String name, Integer salary, LocalDate workStart)
    {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getWorkStart() {
//    public LocalDate getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Date workStart) {
//    public void setWorkStart(LocalDate workStart) {
        this.workStart = workStart;
    }

    public String toString()
    {
        return name + " - " + salary + " - " +
            (new SimpleDateFormat("dd.MM.yyyy")).format(workStart);
//                workStart.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
