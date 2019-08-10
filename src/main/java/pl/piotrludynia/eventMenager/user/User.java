package pl.piotrludynia.eventMenager.user;


import org.springframework.format.annotation.DateTimeFormat;
import pl.piotrludynia.eventMenager.event.Event;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "This field can't be empty")
    private String name;
    @NotEmpty(message = "This field can't be empty")
    private String lastName;
    @NotEmpty(message = "This field can't be empty")
    private String login;
    private String password;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToMany(mappedBy = "users")
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public User() {

    }

    public User(@NotEmpty(message = "This field can't be empty") String name, @NotEmpty(message = "This field can't be empty") String lastName, @NotEmpty(message = "This field can't be empty") String login,  String password, String email, LocalDate date) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }
}
