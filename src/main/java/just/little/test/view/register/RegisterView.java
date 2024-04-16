package just.little.test.view.register;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.server.VaadinSession;
import io.jmix.core.CoreProperties;
import io.jmix.core.MessageTools;
import io.jmix.core.security.AccessDeniedException;
import io.jmix.flowui.component.formlayout.JmixFormLayout;
import io.jmix.flowui.component.loginform.JmixLoginForm;
import io.jmix.flowui.kit.component.ComponentUtils;
import io.jmix.flowui.view.*;
import io.jmix.securityflowui.authentication.AuthDetails;
import io.jmix.securityflowui.authentication.LoginViewSupport;
import just.little.test.view.login.LoginView;
import just.little.test.view.main.MainView;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import com.vaadin.flow.router.Route;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

@Route(value = "register", layout = MainView.class)
@ViewController("RegisterView")
@ViewDescriptor("register-view.xml")
public class RegisterView extends StandardView implements LocaleChangeObserver {
    private static final Logger log = LoggerFactory.getLogger(LoginView.class);

    @Autowired
    protected CoreProperties coreProperties;

    @Autowired
    private LoginViewSupport loginViewSupport;

    @Autowired
    private MessageBundle messageBundle;

    @Autowired
    private MessageTools messageTools;

    @ViewComponent
    private JmixLoginForm register;

    @Value("${ui.login.defaultUsername:}")
    private String defaultUsername;

    @Value("${ui.login.defaultPassword:}")
    private String defaultPassword;

    protected void initDefaultCredentials() {
        if (StringUtils.isNotBlank(defaultUsername)) {
            register.setUsername(defaultUsername);
        }

        if (StringUtils.isNotBlank(defaultPassword)) {
            register.setPassword(defaultPassword);
        }
    }

    @Subscribe
    public void onInit(final InitEvent event) {
        initLocales();
        initDefaultCredentials();
    }

    protected void initLocales() {
        LinkedHashMap<Locale, String> locales = coreProperties.getAvailableLocales().stream()
                .collect(Collectors.toMap(Function.identity(), messageTools::getLocaleDisplayName, (s1, s2) -> s1,
                        LinkedHashMap::new));

        ComponentUtils.setItemsMap(register, locales);

        register.setSelectedLocale(VaadinSession.getCurrent().getLocale());
    }

    @Override
    public void localeChange(final LocaleChangeEvent event) {
    }

    @Subscribe("register")
    public void onRegister(final LoginEvent event) {
        try {
            loginViewSupport.authenticate(
                    AuthDetails.of(event.getUsername(), event.getPassword())
                            .withLocale(register.getSelectedLocale())
                            .withRememberMe(register.isRememberMe())
            );
        } catch (final BadCredentialsException | DisabledException | LockedException | AccessDeniedException e) {
            log.warn("Register failed for user '{}': {}", event.getUsername(), e.toString());
            event.getSource().setError(true);
        }
    }
}