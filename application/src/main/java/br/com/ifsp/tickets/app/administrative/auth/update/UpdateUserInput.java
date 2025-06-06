package br.com.ifsp.tickets.app.administrative.auth.update;

import br.com.ifsp.tickets.domain.administrative.user.User;

import java.time.LocalDate;

public record UpdateUserInput(
        User author,
        String id,
        String name,
        String bio,
        LocalDate birthDate,
        String document
) {

    public static UpdateUserInput of(User author, String id, String name, String bio, LocalDate birthDate, String document) {
        return new UpdateUserInput(author, id, name, bio, birthDate, document);
    }

}
