package ua.goit.hw8Spring.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.hw8Spring.model.BaseEntity;
import ua.goit.hw8Spring.model.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements BaseEntity<String> {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Role role;

    @Override
    public String getId() {
        return email;
    }
}
