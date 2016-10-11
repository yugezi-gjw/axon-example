package com.varian.ois.sample.exploringaxon.eventhandler;

import com.varian.ois.sample.exploringaxon.model.AccountEntity;
import com.varian.ois.sample.exploringaxon.repositories.AccountQueryRepository;
import com.varian.ois.sample.exploringaxon.api.event.AccountCreditedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gbt1220 on 9/27/2016.
 */
@Component
public class AnotherAccountCreditedEventHandler {
    @Autowired
    private AccountQueryRepository accountQueryRepository;

    @EventHandler
    public void handleAccountCreditedEvent(AccountCreditedEvent accountCreditedEvent) {
        System.out.println("Events Handled With EventMessage " + accountCreditedEvent.getAccountNo());

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setIdentifier(accountCreditedEvent.getAccountNo());
        accountEntity.setAccountNo(accountCreditedEvent.getAccountNo());
        accountEntity.setBalance(accountCreditedEvent.getBalance());

        accountQueryRepository.save(accountEntity);
    }
}
