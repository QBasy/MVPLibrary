package just.little.test.view.register;


import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import io.jmix.core.CoreProperties;
import io.jmix.core.security.UserRepository;
import io.jmix.flowui.view.*;
import just.little.test.view.main.MainView;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Route(value = "register", layout = MainView.class)
@ViewController("RegisterView")
@ViewDescriptor("register-view.xml")
public class RegisterView extends StandardView {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    protected CoreProperties coreProperties;

    @Autowired
    private MessageBundle messageBundle;

    @Autowired
    private UserRepository userRepository;

    private TextField firstName;
    private TextField lastName;
    private TextField username;
    private TextField email;
    private PasswordField password;
    private PasswordField repeatPassword;
    private Button submitButton;

    @Autowired
    public RegisterView(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    protected void onAttach(AttachEvent attachEvent) {
        firstName = new TextField();
        firstName.setId("fname");

        lastName = new TextField();
        lastName.setId("lname");

        username = new TextField();
        username.setId("username");

        email = new TextField();
        email.setId("email");

        password = new PasswordField();
        password.setId("password");

        repeatPassword = new PasswordField();
        repeatPassword.setId("rpassword");

        submitButton = new Button("Submit");
        repeatPassword.setId("btn");
    }

    @Subscribe
    protected void onSubmitClick(ClickEvent<Button> event) {
        String firstNameValue = firstName.getValue();
        String lastNameValue = lastName.getValue();
        String usernameValue = username.getValue();
        String emailValue = email.getValue();
        String passwordValue = password.getValue();
        String repeatPasswordValue = repeatPassword.getValue();

        if (validate(passwordValue, repeatPasswordValue)) {
            return;
        }

        String query = "INSERT INTO \"user_\" (username,first_name,last_name,email,password) VALUES (?,?,?,?,?)";
        if (submitButton.isEnabled()) {
            jdbcTemplate.update(query, usernameValue, firstNameValue, lastNameValue, emailValue, passwordValue);
        }
    }

    private boolean validate(String password, String repeatPassword) {
        return !password.equals(repeatPassword);
    }
}

