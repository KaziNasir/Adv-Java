package simple.app.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Employee {

    private long id;
    private String name;
    private boolean isStaff;
    private Date joiningDate;

    private long annualLeaves;

    private long sickLeaves;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(boolean staff) {
        isStaff = staff;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getJoiningDate() {
        return joiningDate;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public long getAnnualLeaves() {
        return annualLeaves;
    }

    public void setAnnualLeaves(long annualLeaves) {
        this.annualLeaves = annualLeaves;
    }

    public long getSickLeaves() {
        return sickLeaves;
    }

    public void setSickLeaves(long sickLeaves) {
        this.sickLeaves = sickLeaves;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isStaff=" + isStaff +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
