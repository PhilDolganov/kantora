package strings;

import java.util.Locale;

import static java.lang.String.format;
import static java.util.Locale.*;


class DataHolder {
    int intField = 1;
    long longField = 2L;
    float floatField = 3.0f;
    double doubleField = 4.0;
    public String toString() {
        StringBuilder result = new StringBuilder("DataHolder: \n");
        result.append(format(Locale.US, "intField: %d\n", intField));
        result.append(format(Locale.US, "longField: %d\n", longField));
        result.append(format(Locale.US, "longField: %f\n", floatField));
        result.append(format(Locale.US, "longField: %e\n", doubleField));
        return result.toString();
    }
}
public class E06_ClassDump {
    public static void main(String[] args){
        System.out.println(new DataHolder());
    }
}