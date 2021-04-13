package engine.pp;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
///Klasa zawierająca funkcjonalność klienta
/**W klasie tej znajduje się połączenie klienta z serwerem (localhost bądź odpowiednie ip), implementacja RMI (pobranie rejestru i interfejsu od serwera, wywoałenie żądanych funkcji serwera). */
public class Client {

    private Client(){};

    public static void main(String[] args) {
        String host = (args.length<1) ? null : args[0];
        try
        {
            Registry registry = LocateRegistry.getRegistry(host);
            ServerInt stub = (ServerInt) registry.lookup("ServerInt");
            String response = stub.showResolution();

            System.out.println("Resolution: " + response);
            System.out.println("If you agree - choose 1, disagree - choose 2, or if you suspend - choose 3");

            Scanner input = new Scanner(System.in);
            int i=input.nextInt();
            /** Wybór głosu przez klienta oraz wywołanie funkcji serwera */
            switch (i) {
                case 1:
                {
                    String info = stub.voteAgree();
                    System.out.println(info);
                }
                case 2:
                {
                    String info = stub.voteDisagree();
                    System.out.println(info);
                }
                case 3:
                {
                    String info = stub.voteSuspended();
                    System.out.println(info);
                }

            }
            String results = stub.showVotes();
            System.out.println(results);

        }catch (Exception e)
        {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }

}

