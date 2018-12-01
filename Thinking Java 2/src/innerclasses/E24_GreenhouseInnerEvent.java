package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

class GreenHouseControllsWithFan extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {super(delayTime);}

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }
    public class LightOff extends Event {
        public LightOff(long delayTime) {super(delayTime);}

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = false;
        }

        @Override
        public String toString() {
            return "light is off";
        }
    }
    private boolean fan = false;
    public class FanOn extends Event {
        public FanOn(long delayTime) {super(delayTime);}

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the fan.
            fan = true;
        }

        @Override
        public String toString() {
            return "Fan is on";
        }
    }
    public class FanOff extends Event {
        public FanOff(long delayTime){super(delayTime);}

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn off the fan.
            fan = false;
        }

        @Override
        public String toString() {
            return "Fan is off";
        }
    }
    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) { super(delayTime);}

        @Override
        public void action() {
            // Put hardware control code here.
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public class WaterOff extends Event {
        public WaterOff(long delayTime){super(delayTime);}

        @Override
        public void action() {
            // Put hardware control here
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }
    private String thermostat = "Day";
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {super(delayTime);}

        @Override
        public void action() {
            // Put hardware control here
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime){super(delayTime);}

        @Override
        public void action() {
            // Put hardware control here
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }
    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends Event {
        public Bell(long delayTime){super(delayTime);}

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }
    public class Restart extends Event {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList)
                addEvent(e);
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // Return each event
                addEvent(e);
            }
            start(); // Return this Event
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }
    public static class Terminate extends Event {
        public Terminate(long delayTime){super(delayTime);}

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}
public class E24_GreenhouseInnerEvent {
    public static void main (String[] args){
        GreenHouseControllsWithFan gc = new GreenHouseControllsWithFan();
        // Instead of hand-writing, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new FanOn(300),
                gc.new LightOff(400),
                gc.new FanOff(500),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(new GreenHouseControllsWithFan.Terminate(new Integer(0)));
        gc.run();
    }
}
