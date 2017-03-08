package me.gomko.api.repository;


import me.gomko.api.domain.ApiInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by USER on 2017-01-09.
 */
@Repository
public interface ApiInfoRepository extends JpaRepository<ApiInfo,Long> {

    ApiInfo findByPath(String path);
}
