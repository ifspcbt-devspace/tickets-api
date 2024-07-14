package br.com.ifsp.tickets.infra.config.app;

import br.com.ifsp.tickets.app.ticket.TicketService;
import br.com.ifsp.tickets.app.ticket.TicketServiceFactory;
import br.com.ifsp.tickets.domain.event.IEventGateway;
import br.com.ifsp.tickets.domain.ticket.ITicketGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class TicketConfig {
    private final IEventGateway eventGateway;
    private final ITicketGateway ticketGateway;

    @Bean
    public TicketService ticketService() {
        return TicketServiceFactory.create(eventGateway, ticketGateway);
    }
}
