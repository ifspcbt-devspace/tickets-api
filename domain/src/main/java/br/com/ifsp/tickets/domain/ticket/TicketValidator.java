package br.com.ifsp.tickets.domain.ticket;

import br.com.ifsp.tickets.domain.shared.validation.IValidationHandler;
import br.com.ifsp.tickets.domain.shared.validation.Validator;

public class TicketValidator extends Validator {

    private final Ticket ticket;

    public TicketValidator(IValidationHandler aHandler, Ticket ticket) {
        super(aHandler);
        this.ticket = ticket;
    }

    @Override
    public void validate() {
        if (ticket.getUserID() == null)
            error("User ID is required");

        if (ticket.getTicketSaleID() == null)
            error("TicketSale ID is required");

        if(ticket.getEventID() == null)
            error("Event ID is required");

        if(ticket.getPaymentStatus() == null)
            error("Payment Status is required");

        if (ticket.getStatus() == null)
            error("Status is required");

        if (ticket.getValidIn() == null)
            error("Validation date is required");

        if (ticket.getExpiredIn() == null)
            error("Expiration date is required");

        if (ticket.getValidIn() != null && ticket.getExpiredIn() != null && ticket.getValidIn().isAfter(ticket.getExpiredIn()))
            error("Validation date must be before expiration date");

    }

}
