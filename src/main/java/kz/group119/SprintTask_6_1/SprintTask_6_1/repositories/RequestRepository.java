package kz.group119.SprintTask_6_1.SprintTask_6_1.repositories;

import kz.group119.SprintTask_6_1.SprintTask_6_1.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<ApplicationRequest, Long> {
    List<ApplicationRequest> findAllByHandled(boolean handled);
}
