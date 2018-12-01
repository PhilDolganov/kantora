package typeinfo.pets2;

import typeinfo.pets.Dog;

public class Mutt extends Dog {
    public static class Factory implements typeinfo.factory.Factory<Mutt>{
        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
