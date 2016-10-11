package com.varian.ois.sample.exploringaxon.web;

import com.varian.ois.sample.exploringaxon.api.command.CreditAccountCommand;
import com.varian.ois.sample.exploringaxon.api.command.DebitAccountCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dadepo Aderemi.
 */
@Controller
public class ExploringAxonController {
//
//    @Autowired
//    @Qualifier("replayCluster")
//    ReplayingCluster replayCluster;
//
//    @Autowired
//    AccountCreditedReplayEventHandler replayEventHandler;


    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping("/debit")
    @Transactional
    @ResponseBody
    public void doDebit(@RequestParam("acc") String accountNumber, @RequestParam("amount") double amount) {
        DebitAccountCommand debitAccountCommandCommand = new DebitAccountCommand(accountNumber, amount);
        commandGateway.send(debitAccountCommandCommand);
    }

    @RequestMapping("/credit")
    @Transactional
    @ResponseBody
    public void doCredit(@RequestParam("acc") String accountNumber, @RequestParam("amount") double amount) {
        CreditAccountCommand creditAccountCommandCommand = new CreditAccountCommand(accountNumber, amount);
        commandGateway.send(creditAccountCommandCommand);
    }

    @RequestMapping("/events")
    public String doReplay(Model model) {
//        replayCluster.startReplay();
//        model.addAttribute("events",replayEventHandler.getAudit());
        return "events";
    }
}
