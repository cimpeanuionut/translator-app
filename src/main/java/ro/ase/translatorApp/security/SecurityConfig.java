package ro.ase.translatorApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ro.ase.translatorApp.userManagement.TipUser;
import ro.ase.translatorApp.userManagement.User;
import ro.ase.translatorApp.userManagement.UserDetails;
import ro.ase.translatorApp.userManagement.UserSingleton;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/**").hasAnyRole("ADMIN","USER")
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for(User user: createUsers()){
            auth.inMemoryAuthentication().withUser(user.getUsername()).password("{noop}" + user.getPassword()).roles(user.getRol().toString());
        }
    }

    private List<User> createUsers() {
        UserSingleton userSingleton = UserSingleton.getInstance();
        userSingleton.addUser(new UserDetails("guest","guest123", TipUser.USER));
        userSingleton.addUser(new UserDetails("guest2","guest321",TipUser.USER));
        userSingleton.addUser(new UserDetails("admin","admin123",TipUser.ADMIN));
        return userSingleton.getUsers();
    }
}
