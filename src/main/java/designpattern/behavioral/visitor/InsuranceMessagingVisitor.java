package designpattern.behavioral.visitor;

import java.util.List;

public class InsuranceMessagingVisitor implements Visitor {

    // With DOUBLE DISPATCH procedure implemented,
    // We have now got rid of instance check (or typecasting) to
    // apply messaging functionality to the required Client
    public void sendInsuranceMails(List<Client> clients) {
        for(Client client : clients) {
            // Plug-In the Interface Implementation
            client.accept(this);
        }
    }

    @Override
    public void visitBank(Bank bank) {
        // Logic to send mail about Theft Insurance
    }

    @Override
    public void visitCompany(Company company) {
        // Logic to send mail about Equipment Insurance
    }

    @Override
    public void visitResident(Resident resident) {
        // Logic to send mail about Medical Insurance
    }

    @Override
    public void visitRestaurant(Restaurant restaurant) {
        // Logic to send mail about Fire and Food Insurance
    }
}
