package be.mj.tasksmanager.repository;

import be.mj.tasksmanager.model.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TaskUser, Long>
{
}
