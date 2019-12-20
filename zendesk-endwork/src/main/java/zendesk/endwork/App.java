/*
 * Programme qui permet de jouer des sons wow
 */
package zendesk.endwork;


import org.zendesk.client.v2.Zendesk;
import org.zendesk.client.v2.model.Status;
import org.zendesk.client.v2.model.Ticket;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;


public class App {


    public static void main(String[] args) throws IOException {
        Zendesk zd = new Zendesk.Builder("https://z3n-pierre-stage.zendesk.com")
                .setUsername("...")
                .setPassword("...")
                .build();
        Iterable<Ticket> oldsource = zd.getTickets();
        ArrayList<Ticket> OldTicketList = new ArrayList();
        oldsource.forEach(OldTicketList::add);

        Iterable<Ticket> newsource = zd.getTickets();
        ArrayList<Ticket> newTicketList = new ArrayList();
        newsource.forEach(newTicketList::add);

        int oldtermine = 0;
        int newtermine = 0;



        for (Ticket ticket : zd.getTickets())
        {
            if (ticket.getStatus().equals(Status.SOLVED))
            {
                oldtermine += 1;
                newtermine += 1;


            }



        }



        while (true)
        {

            newtermine = 0;
            for (Ticket ticket : zd.getTickets()) {
                if (ticket.getStatus().equals(Status.SOLVED))
                {
                    newtermine += 1;
                }
            }


            newTicketList.clear();
            newsource.forEach(newTicketList::add);
            if (OldTicketList.size() != newTicketList.size())
            {
                java.awt.Desktop.getDesktop().open(new File("/Users/zdloaner/Downloads/Travail.mp3"));
                OldTicketList.clear();
                oldsource = zd.getTickets();
                oldsource.forEach(OldTicketList::add);


            }
            if (oldtermine != newtermine)
            {
                java.awt.Desktop.getDesktop().open(new File("/Users/zdloaner/Downloads/Terminé.mp3"));
                oldtermine = newtermine;

            }

        }


}
}

























