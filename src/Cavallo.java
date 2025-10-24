/*questa classe è il nostro primo thread e consentirà la simulazione di un cavallo in corsa parallelamente con altri della stessa specie
 * @author mincigrucci
 * @version 1.0
 * */
public class Cavallo extends Thread{

    private final String name;
    private int lentezza;
    private boolean interrotto = false;
    
    public Cavallo(String name, int lentezza) {
        super();
        this.name = name;
        this.lentezza = lentezza;
    }
    /**override del metodo run */
    @Override
    public void run(){
        System.out.println("Cavallo " +
                name + " comincia il suo galoppo");
        for (int i = 1; i <= 10 && !Thread.currentThread().isInterrupted(); i++) {
            try {
                sleep(lentezza);
            } catch (InterruptedException e) {
                interrotto = true;
                System.out.println(name + " è stato interrotto!");
                return;
            }
            System.out.println(name +" cavalca - passo: " + i);
        }
        if(Main.getPrimo().equals("") && !interrotto){
            Main.setPrimo(this.name);
        }
    }

    protected int getLentezza(){
        return lentezza;
    }

    protected void setLentezza(int lentezza){
        this.lentezza=lentezza;
    }
}

