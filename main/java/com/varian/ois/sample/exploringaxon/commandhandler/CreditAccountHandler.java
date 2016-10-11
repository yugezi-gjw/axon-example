package com.varian.ois.sample.exploringaxon.commandhandler;

import com.varian.ois.sample.exploringaxon.model.Account;
import com.varian.ois.sample.exploringaxon.api.command.CreditAccountCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * Created by Dadepo Aderemi.
 */
@Component
public class CreditAccountHandler {

    private Repository<Account> repository;
//
//    @Autowired
//    public CreditAccountHandler(Repository repository) {
//        this.repository = repository;
//    }

    @CommandHandler
    public void handle(CreditAccountCommand creditAccountCommandCommand){
        Account accountToCredit = repository.load(creditAccountCommandCommand.getAccount());
        accountToCredit.credit(creditAccountCommandCommand.getAmount());
    }

    @Autowired
    public void setRepository(Repository<Account> repository) {
        this.repository = repository;
    }
}
