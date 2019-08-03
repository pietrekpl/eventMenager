package pl.piotrludynia.eventMenager.user;


import org.springframework.format.annotation.DateTimeFormat;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;



public class User {


    @NotEmpty(message = "This field can't be empty")
    private String name;
    @NotEmpty(message = "This field can't be empty")
    private String lastName;
    @NotEmpty(message = "This field can't be empty")
    private String login;
    @Min(value = 5L, message = "Password should have at least 5 characters")
    private String password;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    public User() {

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
}
