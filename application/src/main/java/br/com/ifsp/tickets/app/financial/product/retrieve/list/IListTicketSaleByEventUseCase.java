package br.com.ifsp.tickets.app.financial.product.retrieve.list;

import br.com.ifsp.tickets.app.IUseCase;
import br.com.ifsp.tickets.app.financial.product.retrieve.Ticket2SellOutput;
import br.com.ifsp.tickets.domain.shared.search.Pagination;

public interface IListTicketSaleByEventUseCase extends IUseCase<String, Pagination<Ticket2SellOutput>> {
}
