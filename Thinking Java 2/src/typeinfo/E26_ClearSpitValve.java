package typeinfo;
// We'll use the last-defined version of the instrument hierarchy:

import static net.mindview.util.Print.print;

interface Instrument {
    void play();
    String what();
    void adjust();
    void prepareInstrument();
}
 class Wind implements Instrument {
     @Override
     public void play() {
         print("Wind.play()");
     }

     @Override
     public String what() {
         return "Wind";
     }

     @Override
     public void adjust() {}
     public void clearSpitValve() {
         print("Wind.clearSpitValve");
     }

     @Override
     public void prepareInstrument() {
         clearSpitValve();
     }
 }
 class Percussion implements Instrument {
     @Override
     public void play() {
         print("Percussion.play()");
     }

     @Override
     public String what() {
         return "Percussion";
     }

     @Override
     public void adjust() {}

     @Override
     public void prepareInstrument() {
         print("Percussion.prepareInstrument");
     }
 }
 class Stringed implements Instrument {
     @Override
     public void play() {
         print("Stringed.play()");
     }

     @Override
     public String what() {
         return "Stringed";
     }

     @Override
     public void adjust() {}

     @Override
     public void prepareInstrument() {
         print("Stringed.prepareInstrument");
     }
 }
 class Brass extends Wind {
     @Override
     public void play() {
         print("Brass.play()");
     }

     @Override
     public void adjust() {
         print("Brass.adjust()");
     }

     @Override
     public void clearSpitValve() {
         print("Brass.clearSpitValve");
     }
 }
 class Woodwind extends Wind {
     @Override
     public void play() {
         print("Woodwind.play()");
     }

     @Override
     public String what() {
         return "Woodwind";
     }

     @Override
     public void clearSpitValve() {
         print("Woodwind.clearSpitValve");
     }
 }
 class Music5 {
    static void tune(Instrument i){
        // ...
        i.play();
    }
    static void tuneAll(Instrument[] e){
        for (Instrument instrument : e)
            tune(instrument);
    }
    static void prepareAll(Instrument[] e){
        for (Instrument instrument : e)
            instrument.prepareInstrument();
    }
 }

public class E26_ClearSpitValve {
    public static void main(String[] args){
        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind()};
        Music5.prepareAll(orchestra);
        Music5.tuneAll(orchestra);
    }
}
