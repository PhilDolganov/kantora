package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Processor3<T,E extends Exception,F extends Exception> {
    void process(List<T> resultCollector) throws E, F;
}

class ProcessRunner3<T,E extends Exception, F extends Exception> extends ArrayList<Processor3<T,E,F>>{
    List<T> processAll() throws E,F {
        List<T> resultCollector = new ArrayList<T>();
        for (Processor3<T, E, F> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}

class Failure1_1 extends Exception {}
class Failure1_2 extends Exception {}

class Processor1_1 implements Processor3<String,Failure1_1,Failure1_2>{
    static Random rand = new Random(47);
    static int count = 3;
    public void process(List<String> resultCollector) throws Failure1_1, Failure1_2 {

        if (count-- > 1)
            resultCollector.add("Help!");
        else
            resultCollector.add("Ho!");
        if (count < 0)
            if (rand.nextBoolean())
                throw new Failure1_1();
        throw new Failure1_2();
    }
}
class Failure2_1 extends Exception {}
class Failure2_2 extends Exception {}

class Processor2_2 implements Processor3<Integer,Failure2_1,Failure2_2>{
    static Random rnd = new Random(47);
    static int count = 2;
    public void process(List<Integer> resultsCollector) throws Failure2_1, Failure2_2 {
        if (count-- == 0)
            resultsCollector.add(47);
        else {
            resultsCollector.add(11);
        }
        if (count < 0)
            if (rnd.nextBoolean())
                throw new Failure2_1();
        throw new Failure2_2();
    }
}
public class E36_GenericExceptions {
    public static void main(String[] args) {
        ProcessRunner3<String,Failure1_1,Failure1_2> runner = new ProcessRunner3<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1_1());
            try {
                System.out.println(runner.processAll());
            } catch (Failure1_1 e) {
                System.out.println(e);
            } catch (Failure1_2 e){
                System.out.println(e);
            }
            ProcessRunner3<Integer,Failure2_1,Failure2_2> runner2 = new ProcessRunner3<>();
            for (int j  = 0; j < 3; j++)
                runner2.add(new Processor2_2());

            try {
                System.out.println(runner2.processAll());
            } catch (Failure2_1 e) {
                System.out.println(e);
            } catch (Failure2_2 e) {
                System.out.println(e);
            }
        }
    }
}
