package com.amartus.domain;

/**
 * Created by khe on 2017-01-24.
 */
public class Employee {

    private static final Integer DEFAULT_VACATION_DAYS_IN_YEAR = 26;

    /**
     * The name of the employee
     * */
    private String name;

    /**
     * The last name of the employee
     * */
    private String lastname;

    /**
     * Vacation days available to the employee in the calendar year
     * */
    private Integer vacationDays;

    private String email;

    /**
     * Constructor creates employee object with default vacation days number
     * and the empty projects' list
     *
     * @param name  the name of the employee
     * @param lastname  the last name of the emplyee
     * */
    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.vacationDays = DEFAULT_VACATION_DAYS_IN_YEAR;
        this.email = name.toLowerCase() + "." + lastname.toLowerCase() + "@amartus.com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(Integer vacationDays) {
        this.vacationDays = vacationDays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!getName().equals(employee.getName())) return false;
        return getLastname().equals(employee.getLastname());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getLastname().hashCode();
        return result;
    }
}
