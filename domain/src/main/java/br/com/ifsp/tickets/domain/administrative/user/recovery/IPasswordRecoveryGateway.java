package br.com.ifsp.tickets.domain.administrative.user.recovery;

import br.com.ifsp.tickets.domain.administrative.user.User;
import br.com.ifsp.tickets.domain.administrative.user.UserID;

import java.util.Optional;

public interface IPasswordRecoveryGateway {

    PasswordRecovery create(PasswordRecovery passwordRecovery);

    PasswordRecovery update(PasswordRecovery passwordRecovery);

    boolean existsNonExpiredTokenByUser(User user);

    Optional<PasswordRecovery> findByToken(String token);

    Optional<PasswordRecovery> findByUserID(UserID userID);

    void deleteNonExpiredTokenByUser(User user);

}
