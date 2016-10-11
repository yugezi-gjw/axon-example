package com.varian.ois.sample.exploringaxon.replay;

import org.axonframework.eventhandling.replay.ReplayAware;
import org.springframework.stereotype.Component;

@Component
public class AccountCreditedReplayEventHandler implements ReplayAware {
    @Override
    public void beforeReplay() {

    }

    @Override
    public void afterReplay() {

    }

    @Override
    public void onReplayFailed(Throwable throwable) {

    }
/*
    List<String> audit = new ArrayList<>();

    @EventHandler
    public void handle(AccountCreditedEvent event) {
        String auditMsg = String.format("%s credited to account with account no {%s} on %s",
                event.getAmountCredited(), event.getAccountNo(), formatTimestampToString(event.getTimeStamp()));
        audit.add(auditMsg);
    }

    @EventHandler
    public void handle(AccountDebitedEvent event) {
        String auditMsg = String.format("%s debited from account with account no {%s} on %s",
                event.getAmountDebited(), event.getAccountNo(), formatTimestampToString(event.getTimeStamp()));
        audit.add(auditMsg);
    }

    public List<String> getAudit() {
        return audit;
    }

    @Override
    public void beforeReplay() {
        audit.clear();
    }

    @Override
    public void afterReplay() {
    }

    @Override
    public void onReplayFailed(Throwable cause) {}

    private String formatTimestampToString(long timestamp) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(timestamp * 1000);
    }*/
}
