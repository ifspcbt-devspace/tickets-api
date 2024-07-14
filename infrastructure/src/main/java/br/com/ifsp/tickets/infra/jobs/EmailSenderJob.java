package br.com.ifsp.tickets.infra.jobs;

import br.com.ifsp.tickets.domain.communication.email.IEmailGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
public class EmailSenderJob {
    private final IEmailGateway emailGateway;

    @Scheduled(fixedDelay = 10 * 1000)
    public void sendEmails() {
        this.emailGateway.findNotSent().forEach(email -> {
            this.emailGateway.send(email);
        });
    }
}
