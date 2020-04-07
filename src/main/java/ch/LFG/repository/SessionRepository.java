package ch.LFG.repository;

import ch.LFG.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<User, Long> { //Integer
    //Find, Update, Save, Delete, and others get generated by the interface we extend
}
