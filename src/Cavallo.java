/**
 * La classe {@code Cavallo} rappresenta un singolo cavallo nella corsa.
 * Ogni cavallo viene eseguito come {@link Thread} per simulare
 * la corsa in parallelo con altri cavalli.
 * 
 * <p>Funzionalità principali:</p>
 * <ul>
 *   <li>Simulazione di corsa con passi e tempo di attesa</li>
 *   <li>Gestione dell'interruzione (azzoppamento)</li>
 *   <li>Memorizzazione del primo cavallo arrivato</li>
 * </ul>
 * 
 * @author mincigrucci 
 * @version 1.0
 */
public class Cavallo extends Thread {

    /** Nome del cavallo. */
    private final String name;

    /** Tempo di attesa tra un passo e l'altro (lentezza). */
    private int lentezza;

    /**
     * Costruttore della classe Cavallo.
     * 
     * @param name nome del cavallo
     * @param lentezza tempo di attesa tra i passi
     */
    public Cavallo(String name, int lentezza) {
        super();
        this.name = name;
        this.lentezza = lentezza;
    }

    /**
     * Esegue la simulazione della corsa del cavallo.
     * Il cavallo percorre 10 passi a intervalli di {@link #lentezza} millisecondi.
     * Se è il primo cavallo ad arrivare, aggiorna il vincitore tramite {@link Main#setPrimo(String)}.
     */
    @Override
    public void run() {
        System.out.println("Cavallo " + name + " comincia il suo galoppo");
        for (int i = 1; i <= 10 && !Thread.currentThread().isInterrupted(); i++) {
            try {
                sleep(lentezza);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " cavalca - passo: " + i);
        }
        if (Main.getPrimo().equals("") && !Thread.currentThread().isInterrupted()) {
            Main.setPrimo(this.name);
        }
    }

    /**
     * Restituisce la lentezza del cavallo.
     * 
     * @return tempo di attesa tra un passo e l'altro
     */
    protected int getLentezza() {
        return lentezza;
    }

    /**
     * Imposta la lentezza del cavallo.
     * 
     * @param lentezza tempo di attesa tra un passo e l'altro
     */
    protected void setLentezza(int lentezza) {
        this.lentezza = lentezza;
    }

    /**
     * Restituisce il nome del cavallo.
     * 
     * @return nome del cavallo
     */
    public String getNomeCavallo() {
        return name;
    }
}
