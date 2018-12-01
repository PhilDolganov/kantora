package interfaces.interfaceprocessor;

import static net.mindview.util.Print.print;

public interface Processor {
    String name();
    Object process(Object input);
}
