package com.example.connection.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
DTO is created for sending required amount of data not sending the hole data which is unnecessary to send
 */
@Schema(
        description = "User Data Transfer Object Model"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long id;
    @Schema(
            description = "Username field property"
    )
    @NotEmpty(message = "Username should not be empty")
    private String username;
    @Schema(
            description = "Email field property"
    )
    @Email(message = "Email should be well formatted")
    @NotEmpty(message = "Email Should not be empty")
    private String email;
    @Schema(
            description = "Password field property"
    )
    @NotEmpty(message = "Password should not be empty")
    private String password;
}
