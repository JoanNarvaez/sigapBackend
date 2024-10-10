package com.sigap.SIGAP;

import com.sigap.SIGAP.authentication.entity.PermissionEntity;
import com.sigap.SIGAP.authentication.entity.RoleEntity;
import com.sigap.SIGAP.authentication.entity.RoleEnum;
import com.sigap.SIGAP.authentication.entity.UserEntity;
import com.sigap.SIGAP.authentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SigapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigapApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return arg -> {
			/* CREATE PERMISSIONS*/
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			/*Create Roles */
			RoleEntity rolAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission))
					.build();

			RoleEntity rolUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission,readPermission))
					.build();

			RoleEntity rolInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();

			RoleEntity rolDevelopper = RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission,readPermission,updatePermission,deletePermission,refactorPermission))
					.build();

			/* cREATE USER */

			UserEntity userJoan = UserEntity.builder()
					.username("joan")
					.password("$2a$10$Wu8ngEd8tVvySPPeCK.t9eUjxQcg5O4a6wjUewL.bMUtuppxL3UPi")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolAdmin))
					.build();

			UserEntity userAndres = UserEntity.builder()
					.username("andres")
					.password("$2a$10$Wu8ngEd8tVvySPPeCK.t9eUjxQcg5O4a6wjUewL.bMUtuppxL3UPi")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolUser))
					.build();

			UserEntity userCristian = UserEntity.builder()
					.username("cristian")
					.password("$2a$10$Wu8ngEd8tVvySPPeCK.t9eUjxQcg5O4a6wjUewL.bMUtuppxL3UPi")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolInvited))
					.build();

			UserEntity userAleja = UserEntity.builder()
					.username("aleja")
					.password("$2a$10$Wu8ngEd8tVvySPPeCK.t9eUjxQcg5O4a6wjUewL.bMUtuppxL3UPi")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolDevelopper))
					.build();

			userRepository.saveAll(List.of(userJoan,userAndres,userCristian,userAleja));
		};
	}

}
