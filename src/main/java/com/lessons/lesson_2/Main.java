package com.lessons.lesson_2;

import com.lessons.lesson_2.model.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger("myLogger");

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        Client client1 = ctx.getBean("client1", Client.class);
        Client client2 = ctx.getBean("client2", Client.class);
        Client client3 = ctx.getBean("client3", Client.class);
        Client client4 = ctx.getBean("client4", Client.class);
        //
        Client fakeClient = null;


        Bank bank = ctx.getBean("Bank", Bank.class);
        LOG.info(bank.giveCredit(client1, 6000) + "\n");
        LOG.info(bank.giveCredit(client2, 3000) + "\n");
        LOG.info(bank.giveDeposit(client3, 6000) + "\n");
        LOG.info(bank.giveCredit(client4, 3000) + "\n");

        LOG.info(bank.giveCredit(fakeClient, 3000) + "\n");
    }
}
