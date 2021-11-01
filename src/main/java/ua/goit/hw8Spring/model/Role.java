package ua.goit.hw8Spring.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Optional;

//@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
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
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy="role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<User> users;

}
