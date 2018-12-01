package typeinfo.pets2;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Manx;
import typeinfo.pets.Rodent;

public class Cymric extends Manx {
    public static class Factory implements typeinfo.factory.Factory<Cymric>{
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}


