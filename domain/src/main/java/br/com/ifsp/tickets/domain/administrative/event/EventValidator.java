package br.com.ifsp.tickets.domain.administrative.event;

import br.com.ifsp.tickets.domain.administrative.event.vo.EventConfigKey;
import br.com.ifsp.tickets.domain.shared.validation.IValidationHandler;
import br.com.ifsp.tickets.domain.shared.validation.Validator;

public class EventValidator extends Validator {

    private final Event event;

    public EventValidator(IValidationHandler aHandler, Event event) {
        super(aHandler);
        this.event = event;
    }

    @Override
    public void validate() {
        this.validateName();
        this.validateDescription();
        this.validateInitialDate();
        this.validateEndDate();
        this.validateAddress();
        this.validateCompanyID();
        this.validateConfiguration();
    }

    public void validateName() {
        if (this.event.getName() == null || this.event.getName().isEmpty()) {
            error("Name is required");
        }
    }

    public void validateDescription() {
        if (this.event.getDescription() == null || this.event.getDescription().isEmpty()) {
            error("Description is required");
        }
    }

    public void validateInitialDate() {
        if (this.event.getInitDate() == null) {
            error("InitialDate is required");
        }
    }

    public void validateEndDate() {
        if (this.event.getEndDate() == null) {
            error("EndDate is required");
        } else if (this.event.getEndDate().isBefore(this.event.getInitDate())) {
            error("EndDate must be after InitialDate");
        }
    }

    public void validateAddress() {
        if (this.event.getAddress() == null) {
            error("Address is required");
        }
    }

    public void validateCompanyID() {
        if (this.event.getCompanyID() == null || this.event.getCompanyID().getValue() == null) {
            error("CompanyID is required");
        }
    }

    public void validateConfiguration() {
        for (EventConfigKey value : EventConfigKey.values()) {
            if (this.event.getConfiguration(value) == null) {
                error("Configuration " + value + " is required");
            }
        }
    }

}
