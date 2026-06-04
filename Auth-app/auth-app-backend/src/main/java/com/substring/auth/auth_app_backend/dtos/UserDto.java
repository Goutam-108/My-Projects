package com.substring.auth.auth_app_backend.dtos;


import com.substring.auth.auth_app_backend.entities.Provider;
import com.substring.auth.auth_app_backend.entities.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String email;
    private String name;
    private String password;
    private String image;

    @Builder.Default
    private boolean enable = true;

    @Builder.Default
    private Provider provider = Provider.LOCAL;

    @Builder.Default
    private Set<RoleDto> roles = new HashSet<>();

    // Let the entity manage these — no need in DTO for create
    private Instant createdAt;
    private Instant updatedAt;
}