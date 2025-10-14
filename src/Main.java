public class Main {
/** punto di inizio dell'applicazione
 * thread padre*/
public static void main(String[]arg){
    Cavallo fulmine = new Cavallo( "Fulmine",56);
    Cavallo lampo=new Cavallo ("Lampo",78);
    Cavallo rose = new Cavallo("Rose",5);
    Cavallo margherita = new Cavallo("Margherita",999);
    Cavallo rambo = new Cavallo("Rambo",9);

//    rambo.setPriority(Thread.MAX_PRIORITY);
//    margherita.setPriority(Thread.MIN_PRIORITY);

    fulmine.start();
    rambo.start();
    rose.start();
    margherita.start();
    rambo.start();


}
}