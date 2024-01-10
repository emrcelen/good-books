package com.realworld.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity (name = "Role")
@Table (name = "role")
public enum Role {
    ADMIN, RECOMMENDATORY, USER;
}
