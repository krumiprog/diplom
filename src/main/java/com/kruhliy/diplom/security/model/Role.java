package com.kruhliy.diplom.security.model;

import org.springframework.security.core.GrantedAuthority;

//public enum Role implements GrantedAuthority {
public enum Role {
    USER, ADMIN;
//
//    @Override
//    public String getAuthority() {
//        return name();
//    }
}
