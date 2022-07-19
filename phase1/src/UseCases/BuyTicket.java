package UseCases;

import Entities.Ticket.Ticket;
import Entities.User.TicketAlreadyExistsException;
import Entities.User.User;

// UseCase responsible for assigning a ticket to a Customer (for when a customer buys the ticket)

public class BuyTicket {

    /**
     * Adds a new ticket to a user's collection of tickets.
     * @param user the user buying the ticket
     * @param newTicket the ticket bought by the user
     * @throws TicketAlreadyExistsException throws exception if the ticket pre-exists
     */

    public static void PurchasedTicket(User user, Ticket newTicket) throws TicketAlreadyExistsException {
        user.addTicket(newTicket);
    }
}
