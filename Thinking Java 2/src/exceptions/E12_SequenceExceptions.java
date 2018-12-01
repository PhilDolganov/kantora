package exceptions;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

class SequenceFullException extends RuntimeException {}

class Sequence2 {
    private Object[] objects;
    private int next;
    public Sequence2(int size){ objects = new Object[size]; }
    public void add(Object x){
        if (next < objects.length)
            objects[next++] = x;
        else
            throw new SequenceFullException();
    }

    class SequenceSelector extends Selector {
        private int i;
        public boolean end() { return i == objects.length; }
        public Object current() { return objects[i]; }
        public void next() { if (i < objects.length) i++; }

        @Override
        public boolean isOpen() {
            return false;
        }

        @Override
        public SelectorProvider provider() {
            return null;
        }

        @Override
        public Set<SelectionKey> keys() {
            return null;
        }

        @Override
        public Set<SelectionKey> selectedKeys() {
            return null;
        }

        @Override
        public int selectNow() throws IOException {
            return 0;
        }

        @Override
        public int select(long timeout) throws IOException {
            return 0;
        }

        @Override
        public int select() throws IOException {
            return 0;
        }

        @Override
        public Selector wakeup() {
            return null;
        }

        @Override
        public void close() throws IOException {

        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
}
public class E12_SequenceExceptions {
    public static void main(String[] args){
        Sequence2 sequence = new Sequence2(10);
        for (int i = 0; i < 11; i++)
            sequence.add(Integer.toString(i));
    }
}
