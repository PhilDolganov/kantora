package testResources;

import org.testng.annotations.Test;

public class OctopusTest extends BaseTest {
    public int redTshirtActualValue;
    public int yellowTshirtActualValue;
    public int blueTshirtActualValue;
    public int greenTshirtActualValue;

    @Test (priority = 0)//Green & Red T-shirts are selected, their values are added together. Live Octopus is selected by
    //resulting value. Validated the final value in the text area is 00000005.
    public void greenPlusRed(){
        pageResources.getTestPages().selectGreenTshirt();
        greenTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectRedTshirt();
        redTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().sum(greenTshirtActualValue,redTshirtActualValue);
    }
    @Test (priority = 1)//Yellow & Blue T-shirts are selected, their values are added together. Live Octopus is selected by
    //resulting value. Validated the final value in the text area is 00000005.
    public void yellowPlusBlue(){
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectBlueTshirt();
        blueTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().sum(yellowTshirtActualValue,blueTshirtActualValue);
    }
    @Test (priority = 2)//Yellow, Green & Blue T-shirts are selected, values of yellow & green are multiplied, then value of blue is subtracted.
    // Live Octopus is selected by resulting value. Validated the final value in the text area is 00000005.
    public void yellowTimesGreenMinusBlue(){
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectGreenTshirt();
        greenTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectBlueTshirt();
        blueTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().multiplySubtract(yellowTshirtActualValue,greenTshirtActualValue,blueTshirtActualValue);
    }
    @Test (priority = 3)//Yellow, Green & Blue T-shirts are selected, values of yellow & blue are multiplied, then value of red is subtracted.
    // Live Octopus is selected by resulting value. Validated the final value in the text area is 00000005.
    public void yellowTimesBlueMinusRed(){
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectBlueTshirt();
        blueTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectRedTshirt();
        redTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().multiplySubtract(yellowTshirtActualValue,blueTshirtActualValue,redTshirtActualValue);
    }
    @Test(priority = 4)//Yellow, Green, Red & Blue T-shirts are selected, values of blue & green are multiplied, then divided by value of blue, value of red is then subtracted.
    // Live Octopus is selected by resulting value. Validated the final value in the text area is 00000005.
    public void blueTimesGreenDividedByYellowMinusRed(){
        pageResources.getTestPages().selectBlueTshirt();
        blueTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectGreenTshirt();
        greenTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectRedTshirt();
        redTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().multiplyDivideSubtract(
                blueTshirtActualValue,greenTshirtActualValue,yellowTshirtActualValue,redTshirtActualValue);
    }
    @Test(priority = 5)//Yellow, Green & Red T-shirts are selected, values of green & yellow are added, then value of red is subtracted.
    // Live Octopus is selected by resulting value. Validated the final value in the text area is 00000005.
    public void greenPlusYellowMinusRed(){
        pageResources.getTestPages().selectGreenTshirt();
        greenTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectRedTshirt();
        redTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().addSubtract(greenTshirtActualValue,yellowTshirtActualValue,redTshirtActualValue);
    }
    @Test(priority = 6)//Yellow, Green & Blue T-shirts are selected, values of green & blue are added, then value of yellow is subtracted.
    // Live Octopus is selected by resulting value. Validated the final value in the text area is 00000005.
    public void greenPlusBlueMinusYellow(){
        pageResources.getTestPages().selectGreenTshirt();
        greenTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectBlueTshirt();
        blueTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().selectYellowTshirt();
        yellowTshirtActualValue = Integer.valueOf(pageResources.getTestPages().getSelectedValue());
        pageResources.getTestPages().addSubtract(greenTshirtActualValue,blueTshirtActualValue,yellowTshirtActualValue);
    }
}
