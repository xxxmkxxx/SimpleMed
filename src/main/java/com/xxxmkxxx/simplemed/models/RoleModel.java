package com.xxxmkxxx.simplemed.models;

import com.xxxmkxxx.simplemed.common.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Roles role;

    @ManyToMany(mappedBy = "userRoles")
    private List<UserModel> users;
}
