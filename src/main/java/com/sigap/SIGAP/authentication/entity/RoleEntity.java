package com.sigap.SIGAP.authentication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name ="roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="role_name")
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name ="role_permissions",joinColumns = @JoinColumn(name="role_id"),inverseJoinColumns = @JoinColumn(name="permission_id"))
    private Set<PermissionEntity> permissionList = new HashSet<>();
    //set no me permite repetir usuario en cambio el list me permite agregar el mismo usuario

}
