package me.gomko.api.repository;

import me.gomko.api.domain.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Manki Kim on 2017-03-10.
 */
@Repository
public interface ManualRepository extends JpaRepository<Manual,Long> {
    Manual findByMessage(String msg);
}
