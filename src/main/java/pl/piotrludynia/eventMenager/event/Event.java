package pl.piotrludynia.eventMenager.event;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "This field cant be empty")
    private String name;
    @NotEmpty(message = "This field cant be empty")
    private String localization;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String access;


    public Event() {
    }

    public Event(@NotEmpty(message = "This field cant be empty") String name, @NotEmpty(message = "This field cant be empty") String localization, LocalDate date, String access) {
        this.name = name;
        this.localization = localization;
        this.date = date;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
