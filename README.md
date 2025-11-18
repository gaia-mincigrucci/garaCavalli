
# MINCIGRUCCI Gara Cavalli

Simulatore di corsa di cavalli in Java, realizzato con thread, che permette di gestire una gara virtuale e salvare i risultati su file.

## Descrizione

Questo progetto crea una piccola simulazione di una corsa di cavalli usando i thread di Java.
Ogni cavallo corre nel proprio thread e il primo che completa 10 passi vince.
Il programma funziona tramite un menu testuale e permette anche di salvare il risultato tramite una finestra grafica.

## Funzionalità

* **Aggiunta cavalli**: Inserisci nuovi cavalli dando loro un nome.
* **Imposta velocità**: Scegli il tempo di pausa (sleep) di ogni cavallo, che ne determina la velocità.
* **Avvio della corsa**: Fai partire la gara con i cavalli inseriti.
* **Azzoppa cavallo**: Ferma in modo casuale uno dei cavalli durante la gara.
* **Salvataggio risultati**: Salva il nome del vincitore su file tramite `JFileChooser`.

## Struttura del progetto


src/
├── Main.java            # Classe principale con menu e logica della gara
├── Cavallo.java         # Thread che rappresenta un cavallo
└── FileChooserDemo.java   # Esempio Oracle per l'uso di JFileChooser


## Componenti principali

### Main.java

Gestisce:

* Il menu nella console
* La lista dei cavalli
* L’avvio della corsa
* Il salvataggio del risultato tramite finestra grafica

### Cavallo.java

Estende `Thread` e si occupa di:

* Simulare la corsa (10 passi)
* Gestire l’interruzione del cavallo (azzoppamento)
* Segnalare in modo sincronizzato il vincitore

### Menu opzioni

1. **Insert horse** – Aggiunge un nuovo cavallo con nome.
2. **Insert sleepTime** – Imposta la “lentezza” di un cavallo.
3. **Start the race** – Avvia la corsa.
4. **Azzoppa un cavallo** – Interrompe un cavallo a caso.
5. **Exit** – Esci dal programma.

### Esempio

* Cavallo 1: nome **Furia**, lentezza **100**
* Cavallo 2: nome **Lampo**, lentezza **150**
* Cavallo 3: nome **Saetta**, lentezza **120**

## Dettagli tecnici

### Thread

Ogni cavallo ha un proprio thread. La sincronizzazione del vincitore è gestita con:

* blocco `synchronized` su `Main.class`
* `Thread.join()` per aspettare che tutti i cavalli finiscano

### Interruzione cavalli

Un cavallo può essere “azzoppato” durante la gara usando `Thread.interrupt()`.
Se viene interrotto, esce dalla gara e lo segnala nel terminale.

### Salvataggio su file

Il salvataggio del vincitore avviene tramite `JFileChooser`, che permette all’utente di scegliere dove salvare il file di testo.

## Note

* Un tempo di sleep più basso rende il cavallo più veloce.
* Se non viene impostata una velocità, il valore di default è 0.
* Per ogni gara vengono create nuove istanze dei cavalli, per evitare problemi con thread già usati.
* Vince il primo cavallo che completa 10 passi.

## Licenza

Progetto creato per scopi didattici.
