package containers;

import static net.mindview.util.Print.*;

//Does Math.random() produce 0.0 and 1.0 ?
// {RunByHand}
public class RandomBounds {
    static void usage(){
        print("Usage:");
        print("\tRandomBounds lower");
        print("\tRandomBounds upper");
        System.exit(1);
    }

    public static void main(String[] args) {
        if (args.length != 1) usage();
        if (args[0].equals("lower")){
            while (Math.random() != 0.0);
            // Keep trying
            print("Produced 1.0!");
        } else
            usage();
    }
}
