package pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class TalentPage {
    WebDriver driver;
    WebDriverWait wait;
    public Random rand = new Random();
    JavascriptExecutor ex;
    public TalentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
    //generating random date of birth mm/dd/yyyy
    public String randomDate () {
        int year = randBetween(1900, 2015);
        int month = randBetween(1,12);
        int day;
        String days,months;
        if (month==2){
            day= randBetween(1,28);
        } else {
            day = randBetween(1, 30);
        }
        if (day<10) {
            days= "0"+day;
        } else {
            days=String.valueOf(day);
        }
        if (month<10) {
            months= "0" +month;
        } else {
            months=String.valueOf(month);
        }
        return months+days+year;
    }
    public static int randBetween(int start, int end) {

        return start + (int)Math.round(Math.random() * (end - start));
    }

    @FindBy(xpath = "//label[contains(text(),'Yourself')]//span")
    WebElement youButton;
    @FindBy(xpath = "//div//button[@class=\"confirm\"]")
    WebElement confirmButton;
    @FindBy(xpath = "//label[contains(text(),'Other Talent')]//span")
    WebElement otherButton;
    @FindBy(xpath = "//a[contains(text(),'New')]")
    WebElement newButton;
    @FindBy(xpath = "//i[@ng-click='$select.toggle($event)']")
    WebElement categoryButton;
    @FindBy(xpath = "//div[@ng-attr-id='ui-select-choices-row-{{ $select.generatedId }}-{{$index}}']")
    List<WebElement> categoryList;
    @FindBy(xpath = "//button[contains(.,'Next')]")
    WebElement nextButton;
    @FindBy(id = "firstName")
    WebElement fNameField;
    @FindBy(id = "middleName")
    WebElement mNameField;
    @FindBy(id = "lastName")
    WebElement lNameField;
    @FindBy(id = "address")
    WebElement addressField;
    @FindBy(id = "phone")
    WebElement phoneField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "dateBirth")
    WebElement birthField;
    @FindBy(id = "placeBirth")
    WebElement placeBirthField;
    @FindBy(xpath = "//input[@value='RURAL']")
    WebElement ruralRadio;
    @FindBy(xpath = "//div//label[contains(.,'Privileged')]//span")
    WebElement privelegedRadio;
    @FindBy(id = "height")
    WebElement heightField;
    @FindBy(id ="weight")
    WebElement weightField;
    @FindBy(xpath = "//select[@name=('trainingHistory')]")
    WebElement Select;
    @FindBy(xpath = "//div/label[contains(.,'No')]//span")
    WebElement noRadio;
    @FindBy (xpath = "//div/label[contains(.,'Sometimes')]//span")
    WebElement sometimesRadio;
    @FindBy (xpath = "//input[@name='schoolName']")
    WebElement schoolNameField;
    @FindBy (xpath = "//input[@name='schoolSuccessLevel']")
    WebElement schoolSuccessLevelField;
    @FindBy (xpath = "//div/label[contains(.,'Advanced')]//span")
    WebElement advancedRadio;
    @FindBy (xpath = "//div/label[contains(.,'Family')]//span")
    WebElement familyRadio;
    @FindBy (xpath = "//textarea[@name=('testimony0')]")
    WebElement testimonyField;
    @FindBy (xpath = "//input[@name='workProduct']")
    WebElement workProduct;
    @FindBy (xpath = "//div/label[contains(.,'Middle')]//span")
    WebElement middleRadio;
    @FindBy (xpath = "//select[@name='maritalStatus']")
    WebElement selectMarital;
    @FindBy (xpath = "//select[@name='workStatus']")
    WebElement selectWorkStatus;
    @FindBy (xpath = "//select[@name='relation']")
    WebElement selectRelation;
    @FindBy (xpath = "//input[@placeholder='USD']")
    WebElement usdField;
    @FindBy (xpath = "//select[@name='disabilities']")
    WebElement selectDisability;
    @FindBy (xpath = "//textarea[@name='headline']")
    WebElement headlineField;
    @FindBy (xpath = "//input[@name='discoveryYears']")
    WebElement discoveryYearsField;
    @FindBy (xpath = "//select[@name='interestLevel']")
    WebElement selectInterest;
    @FindBy (xpath = "//span[contains(text(),'Quick Tests')]")
    WebElement quickTestsTab;
    @FindBy (xpath = "//*[@id='talentForm']//wizard-form//div//ol//li[2]")
    WebElement personalTab;
    @FindBy (xpath = "//button[contains(text(),'Finish')]")
    WebElement finishButton;
    public void enterSchoolSuccessLevel(){
        schoolSuccessLevelField.sendKeys(RandomStringUtils.randomAlphanumeric(7));
    }
    public void enterSchoolName(){
        schoolNameField.sendKeys(RandomStringUtils.randomAlphanumeric(7));
    }
    public void sometimesRadioClick(){
        sometimesRadio.click();
    }
    public void noRadioClick(){
        noRadio.click();
    }
    public void selectTraining(){
        int i = rand.nextInt(4);
        Select training = new Select(Select);
        training.selectByIndex(i);
    }
    public void enterWeight(){
        weightField.sendKeys(RandomStringUtils.randomNumeric(2,3));
    }
    public void enterHeight(){
        heightField.sendKeys(RandomStringUtils.randomNumeric(2,3));
    }
    public void privelegedRadioClick(){
        privelegedRadio.click();
    }
    public void ruralRadioClick(){
        ruralRadio.click();
    }
    public void enterPlaceBirth(){
        placeBirthField.sendKeys(RandomStringUtils.randomAlphabetic(5,7));
    }
    public void enterBirth(String dateBirth){
        birthField.sendKeys(dateBirth);
    }
    public void enterEmail(){
        emailField.sendKeys(RandomStringUtils.randomAlphabetic(7)+"@getnada.com");
    }
    public void enterAddress(String address){
        addressField.sendKeys(address);
    }
    public void enterPhone (String phone){
        phoneField.sendKeys(phone);
    }
    public void enterName(String fName,String mName, String lName){
        fNameField.sendKeys(fName);
        mNameField.sendKeys(mName);
        lNameField.sendKeys(lName);
    }
    public void pushNextButton(){
        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",nextButton);
    }
    public void pushYouButton(){
        youButton.click();
    }
    public void pushConfirm(){
        confirmButton.click();
    }
    public void pushOtherButton(){
        otherButton.click();
    }
    public void pushNewButton(){
        ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", newButton);
    }
    public void selectCategory(){
        ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", categoryButton);
        Random rand = new Random();
        int i = rand.nextInt(17);
        categoryList.get(i).click();
    }
    public void pushFinishButton() {
        finishButton.click();
    }
    public void gotoQuickTestsTab() {
        quickTestsTab.click();
    }
    public void interestLevelListSelect() {
        Select interestLevelList = new Select(selectInterest);
        interestLevelList.selectByIndex(rand.nextInt(5));
    }
    public void EnterDiscoveryYears(int year) {
        discoveryYearsField.sendKeys(String.valueOf(randBetween(year,2017)));
    }
    public void EnterHeadline() {
        headlineField.sendKeys(RandomStringUtils.randomAscii(50,150));
    }
    public void disabilitiesListSelect() {
        Select disabilitiesList = new Select(selectDisability);
        List<WebElement> disabilities = disabilitiesList.getOptions();
        int i = disabilities.size();
        disabilitiesList.selectByIndex(rand.nextInt(i));
    }
    public void enterUsdField() {
        usdField.sendKeys(RandomStringUtils.randomNumeric(4,6));
    }
    public void relationListSelect() {
        Select relationList = new Select(selectRelation);
        relationList.selectByIndex(rand.nextInt(4));
    }
    public void workStatusListSelect() {
        Select workStatusList = new Select(selectWorkStatus);
        workStatusList.selectByIndex(rand.nextInt(4));
    }
    public void maritalListSelect() {
        Select maritalList = new Select(selectMarital);
        maritalList.selectByIndex(rand.nextInt(5));
    }
    public void middleRadioClick() {
        middleRadio.click();
    }
    public void enterWorkProduct() {
        workProduct.sendKeys(RandomStringUtils.randomAlphabetic(30,49));
    }
    public void enterTestimony() {
        try {
            testimonyField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        }   catch (StaleElementReferenceException e) {
            testimonyField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        }
    }
    public void familyRadioClick() {
        familyRadio.click();
    }
    public void advancedRadioClick() {
        advancedRadio.click();
    }
}

