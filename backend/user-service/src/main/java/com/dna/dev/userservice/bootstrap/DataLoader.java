package com.dna.dev.userservice.bootstrap;

import com.dna.dev.userservice.model.Authority;
import com.dna.dev.userservice.model.Role;
import com.dna.dev.userservice.model.User;
import com.dna.dev.userservice.repo.AuthorityRepo;
import com.dna.dev.userservice.repo.RoleRepo;
import com.dna.dev.userservice.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class DataLoader implements CommandLineRunner {

    private final AuthorityRepo authRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public DataLoader(AuthorityRepo authRepo, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepo userRepo, RoleRepo roleRepo) {
        this.authRepo = authRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Jdoe",
                "jdoe@gmail.com",
                bCryptPasswordEncoder.encode("password"),
                LocalDate.now(),
                LocalDate.now(),
                null,
                true,
                true);

        Authority readOrder = authRepo.save(new Authority("master.read"));
        Authority createOrder = authRepo.save(new Authority("master.create"));
        Authority updateOrder = authRepo.save(new Authority("master.update"));
        Authority deleteOrder = authRepo.save(new Authority("master.delete"));

        Role superRole = new Role("Super");
        superRole.getAuthorities().add(readOrder);
        superRole.getAuthorities().add(createOrder);
        superRole.getAuthorities().add(updateOrder);
        superRole.getAuthorities().add(deleteOrder);

        superRole = roleRepo.save(superRole);

        Role moderator = new Role("Moderator");
        moderator.getAuthorities().add(readOrder);
        moderator.getAuthorities().add(updateOrder);
        moderator.getAuthorities().add(createOrder);

        roleRepo.save(moderator);

        Role userRole = new Role("User");
        userRole.getAuthorities().add(readOrder);

        roleRepo.save(userRole);

        user.setRole(superRole);

        userRepo.save(user);

    }
}
