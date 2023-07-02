package designpattern.behavioral.visitor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Client bank = new Bank("Bank", "Address", "123", 4);
        Client company = new Company("Company", "Address", "123", 100);

        InsuranceMessagingVisitor visitor = new InsuranceMessagingVisitor();

        // Plug-in single visitor to all the clients at once.
        visitor.sendInsuranceMails(Arrays.asList(bank, company));

        // OR
        // Plug-in visitor(s) individually (if required)
//        bank.accept(visitor);
//        company.accept(visitor);
    }
}
