package ua.goit.hw8Spring.model;

import java.util.Arrays;
import java.util.Optional;

public enum Role{

    ADMIN("ADMIN"),
    USER("USER");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public Optional<Role> getRole(String role){
        return Arrays.stream(Role.values())
                .filter(enumValue -> enumValue.getRole().equals(role))
                .findAny();
    }

}
