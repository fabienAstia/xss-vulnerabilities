package co.simplon.xss_vulnerabilities.repositories;

import co.simplon.xss_vulnerabilities.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    List<Response> findAllProjectedBy();
}
