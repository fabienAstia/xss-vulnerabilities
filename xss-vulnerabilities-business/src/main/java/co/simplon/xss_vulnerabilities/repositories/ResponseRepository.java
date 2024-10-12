package co.simplon.xss_vulnerabilities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.xss_vulnerabilities.entities.Response;

public interface ResponseRepository extends JpaRepository<Response, Long> {

    List<Response> findAllProjectedBy();
}
