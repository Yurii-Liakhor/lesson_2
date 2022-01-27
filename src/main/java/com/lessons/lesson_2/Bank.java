package com.lessons.lesson_2;

import com.lessons.lesson_2.model.Client;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Data
public class Bank {
    @Autowired
    private Logger LOG;

    private List<Client> clients;

    public boolean giveCredit(Client client, double requestMoney) {
        boolean clientExist = !Objects.isNull(client) && clients.contains(client);
        if(!clientExist) {
            LOG.warning("client does't exist");
            return false;
        }
        //calc how much money client can earn by year + 10%
        double solvency = client.getMonthlySalary() * 12 * 0.1;
        return requestMoney < solvency;
    }

    public boolean giveDeposit(Client client, double requestMoney) {
        boolean clientExist = !Objects.isNull(client) && clients.contains(client);
        if(!clientExist) {
            LOG.warning("client does't exist");
            return false;
        }
        return requestMoney >= 1000;
    }
}