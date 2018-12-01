package innerclasses;

import innerclasses.controller.Event;

class GreenhouseControllerWithWMG extends GreenhouseControls {
    private boolean generator = false;
    public class WatermistGeneratorOn extends Event {
        public WatermistGeneratorOn(long delayTime) { super(delayTime);}

        @Override
        public void action() {
            generator = true;
        }

        @Override
        public String toString() {
            return "Water mist generator is on";
        }
    }
    public class WatermistGeneratorOff extends Event {
        public WatermistGeneratorOff(long delayTime) {super(delayTime);}

        @Override
        public void action() {
            generator = false;
        }

        @Override
        public String toString() {
            return "Water mist generator is off";
        }
    }
}
public class E25_GreenhouseController {
    public static void main (String[] args){
        GreenhouseControllerWithWMG gc = new GreenhouseControllerWithWMG();
        // Instead of hand-writing, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400),
                gc.new WatermistGeneratorOn(1600),
                gc.new WatermistGeneratorOff(1800)

        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(new GreenhouseControllerWithWMG.Terminate(new Integer(args[0])));
        gc.run();
    }
}
