package br.com.ifsp.tickets.infra.contexts.communication.email.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EmailRepository extends JpaRepository<EmailJpaEntity, Long> {

    Page<EmailJpaEntity> findBySentIsFalseAndFailedAttemptsIsLessThan(Pageable pageable, int maxAttempts);

    void deleteAllByCreatedAtBefore(LocalDateTime createdAtBefore);

}
