package br.com.ifsp.tickets.infra.contexts.communication.jobs;

import br.com.ifsp.tickets.infra.contexts.communication.email.EmailGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteOldEmailsJob {

    private final EmailGateway emailGateway;

    @Scheduled(cron = "0 0 2 * * ?")
    @Transactional
    public void deleteOldEmails() {
        log.info("Deleting emails older than 7 days");
        final LocalDateTime beforeDate = LocalDate.now().minusDays(7).atStartOfDay();
        this.emailGateway.deleteAllBeforeDate(beforeDate);
        log.info("Emails older than 7 days have been deleted");
    }
}
