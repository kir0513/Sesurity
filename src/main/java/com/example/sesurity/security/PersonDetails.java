package com.example.sesurity.security;

import com.example.sesurity.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/*
класс обертка над сущностью. Когда работаем с security с сущностью работают через класс обертку, предоставляющую информацию
о пользователе. Он должен реализовывать интерфейс UserDetails c методами которые надо реализовать
 */
public class PersonDetails implements UserDetails {
    // храним сущность Person в качестве поля
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }
/*
здесь получаем роли из бд, которые есть у пользователя. Возвращается коллекция прав, которые есть у пользователя
 */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //возвращает пароль пользователя. Обраща6емся к человеку, которого обернули и возвращаем пароль
    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return  this.person.getEmail();
    }
//далее методы, показывающие что аккаунт активен, не заблокан
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
//аккаунт включен, работает
    @Override
    public boolean isEnabled() {
        return true;
    }
}
