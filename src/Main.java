import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * La classe {@code GestoreCavallo} gestisce la simulazione di una corsa tra cavalli.
 * <p>
 * L'utente inserisce i cavalli da tastiera, imposta la lentezza di ciascun cavallo,
 * avvia la corsa con thread paralleli, azzoppa un cavallo casualmente
 * e può salvare il risultato su file tramite {@link JFileChooser}.
 * </p>
 * 
 * <p>Funzionalità principali:</p>
 * <ul>
 *   <li>Inserimento di cavalli e loro lentezza</li>
 *   <li>Simulazione della corsa con thread</li>
 *   <li>Azzoppamento di un cavallo casuale</li>
 *   <li>Salvataggio del vincitore su file</li>
 * </ul>
 * 
 * @author mincigrucci
 * @version 1.0
 */
public class GestoreCavallo {

    /** Nome del cavallo vincitore della corsa. */
    static String primo="";

    /**
     * Metodo principale che gestisce l'inserimento dei cavalli, la corsa
     * e il salvataggio del vincitore.
     *
     * @param args argomenti della riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tmpS;
        int tmp;
        ArrayList<Cavallo> listaCavallo = new ArrayList<Cavallo>();

        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserisci il nome del cavallo " + i);
            tmpS =  input.nextLine();
            System.out.println("Inserisci la lentezza del cavallo " + i);
            tmp = input.nextInt();
            String v = input.nextLine(); // prende il \n
            Cavallo c=new Cavallo(tmpS, tmp);
            listaCavallo.add(c);
        }

        int n = (int) (Math.random() * 4);
        Cavallo x = listaCavallo.get(n);
        x.interrupt();
        listaCavallo.remove(n);

        for(Cavallo c: listaCavallo){
            c.start();
        }

        System.out.println("Cavallo azzoppato: "+ x.getNomeCavallo());

        for(Cavallo c: listaCavallo){
            try {
                c.join();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
        }

        System.out.println("Il primo cavallo: " + primo);

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Salva il vincitore");

        int result = chooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                pw.println("Il primo cavallo è: " + primo);
                System.out.println("Risultato salvato correttamente in: " + file.getName());
            } catch (IOException e) {
                System.out.println("Errore durante il salvataggio!");
            }
        }
    }

    /**
     * Restituisce il nome del cavallo vincitore.
     *
     * @return nome del cavallo vincitore
     */
    public static String getPrimo() {
        return primo;
    }

    /**
     * Imposta il nome del cavallo vincitore.
     *
     * @param primo nome del cavallo vincitore
     */
    public static void setPrimo(String primo) {
        GestoreCavallo.primo = primo;
    }
}
