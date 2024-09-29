package com.lims.lims_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "AppUser")
public class AppUser {
    @Id
    private int user_id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String email;
    private String contact_number;

}
