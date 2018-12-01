package typeinfo.coffee2;

public class Cappucino extends Coffee {
    public static class Factory implements typeinfo.factory.Factory<Cappucino>{
        @Override
        public Cappucino create() {
            return new Cappucino();
        }
    }
}
