import model.MobileApp;

import java.time.LocalDate;
import java.util.Scanner;
import model.Recensione;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esci = false;
        float prezzo = 0;
        int numeroDownload = 0;

        //chiedere all'utente di inserire nome, sistemaOperativo, prezzo dell'app
        System.out.print("Inserisci il nome dell'app: ");
        String nome = sc.nextLine();
        System.out.print("Inserisci il sistema operativo: ");
        String sistemaOperativo = sc.nextLine();
        do {
            System.out.print("Inserisci il prezzo dell'app: ");
            try {
                prezzo = Float.parseFloat(sc.nextLine());
                break; // esci se hanno messo un numero
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero.");
            }
        } while (true);

        // Crea un oggetto MobileApp passando dati inseriti sopra
        MobileApp mobileApp = new MobileApp(nome, sistemaOperativo, prezzo);

        //Menù
        while (!esci) {
            System.out.println("\nMenu:");
            System.out.println("1. Download singolo");
            System.out.println("2. Download multiplo");
            System.out.println("3. Ricevi recensione");
            System.out.println("4. Visualizza recensioni");
            System.out.println("5. Esci");
            System.out.print("\nFai la tua selezione (0 per uscire): ");
            String scelta = sc.nextLine();

            switch (scelta) {
                case "1":
                    mobileApp.download();
                    System.out.println("Grazie per aver scaricato la nostra app!");
                    System.out.println("\nPremi invio per continuare...");
                    sc.nextLine();
                    break;
                case "2":
                    do {
                        System.out.print("Inserisci il numero di download: ");
                        try {
                            numeroDownload = Integer.parseInt(sc.nextLine());
                            break; // esci se numero
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: devi inserire un numero valido per il numero di download.");
                        }
                    } while (true);
                    // se tutto va bene l'utente può downloadare
                    mobileApp.download(numeroDownload);
                    System.out.println("Grazie per aver effettuato " + numeroDownload + " downloads della nostra app!");
                    System.out.println("\nPremi invio per continuare...");
                    sc.nextLine();
                    break;
                case "3":
                    try {
                        // chiedo i parametri da inserire nel cotruttore delle recensioni
                        System.out.print("Inserisci il nome utente: ");
                        String nomeUtente = sc.nextLine();

                        System.out.print("Inserisci il numero di stelle (da 1 a 5): ");
                        int numeroStelle = Integer.parseInt(sc.nextLine());

                        System.out.print("Inserisci il testo della recensione: ");
                        String testoRecensione = sc.nextLine();

                        // richiamo il costruttore delle recensioni
                        Recensione recensione = new Recensione(LocalDate.now(), nomeUtente, numeroStelle, testoRecensione);
                        mobileApp.riceviRecensione(recensione);
                        System.out.println("Grazie per aver lasciato una recensione!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    System.out.println("\nPremi invio per continuare...");
                    sc.nextLine();
                    break ;
                case "4":
                    System.out.println("\nElenco delle recensioni presenti:");
                    for (Recensione r : mobileApp.getElencoRecensioni()) {
                        System.out.println(r.toString());
                    }
                    System.out.println("\nPremi invio per continuare...");
                    sc.nextLine();
                    break;
                case "0":
                    System.out.println("Arrivederci!");
                    esci = true;
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
            // dopo ogni chiamata ad una voce di menu visualizzare i dati della mobile app (valutazione media, ricavo totale)
            System.out.println("Valutazione media: " + mobileApp.valutazioneMedia());
            System.out.println("Ricavo totale: " + mobileApp.getRicavoTotale() + "€");
        } // fine while
        sc.close();
    }
}