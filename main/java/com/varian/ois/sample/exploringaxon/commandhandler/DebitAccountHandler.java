package com.varian.ois.sample.exploringaxon.commandhandler;

import com.varian.ois.sample.exploringaxon.api.command.DebitAccountCommand;
import com.varian.ois.sample.exploringaxon.model.Account;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Dadepo Aderemi.
 */
@Component
public class DebitAccountHandler {

    private Repository<Account> repository;

//    @Autowired
//    public DebitAccountHandler(Repository repository) {
//        this.repository = repository;
//    }

    @CommandHandler
    public void handle(DebitAccountCommand debitAccountCommandCommand){
        Account accountToDebit = repository.load(debitAccountCommandCommand.getAccount());
        accountToDebit.debit(debitAccountCommandCommand.getAmount());
    }

    @Autowired
    public void setRepository(Repository<Account> repository) {
        this.repository = repository;
    }
}
