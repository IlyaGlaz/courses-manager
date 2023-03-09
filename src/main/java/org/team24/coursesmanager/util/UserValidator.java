package org.team24.coursesmanager.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.PersonDetailsService;

@Component
public class UserValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public UserValidator(PersonDetailsService userDetailsService) {
        this.personDetailsService = userDetailsService;
    }

    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }


    public void validate(Object o, Errors errors) {
        User user = (User) o;

        try {
            personDetailsService.loadUserByUsername(user.getEmail());
        } catch (UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }

}
