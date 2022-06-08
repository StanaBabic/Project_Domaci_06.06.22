import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AppointmentPage extends BasePage {
    /*Napisati program koji testira funkcionalnost zakazivanja na satju https://katalon-demo-cura.herokuapp.com/.
    Od klasa je potrebno:

            ·        LoginPage – dodati neophodne metode
·        AppointmentPage
    o   getter za facility select
    o   getter za apply for hospital readmission
    o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme
§ //*[@name='programs'][@value='"+ radioInputName +"']
    o   getter za visit date input
    o   getter za comment input
    o   getter za book appointment button
    o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment"
     (iskoriste logiku preko liste, ako je lista prazna element nije na stanici)
    Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu
 "dd/mm/yyyy" => npr: "21/09/2020"
            ·        SummaryPage
    o   ima gettere za sve elemenete sa summary stranice koji nose informacije appointment-a
·        AppointmentTest
    o   Ucitajte stranicu https://katalon-demo-cura.herokuapp.com/
    o   Ulogovate se na stranicu preko demo naloga
    John Doe/ThisIsNotAPassword
    o   Za proveru da li je korisnik ulogovan iskoristite metodu isFormPresented iz AppointmentPage klase.
    o   Popunite appointment formu
    o   I proverite da li se unosi sa appointment forme uklapaju sa podacima sa summary stranice
    katalon-demo-cura.herokuapp.com
    CURA Healthcare Service
    CURA Healthcare Service; (678) 813-1KMS*/

    private By makeAppointmentBtn = By.id("btn-make-appointment");
    private By facilityBtn = By.id("combo_facility");
    private By applyForHospitalReadmissionBtn = By.id("chk_hospotal_readmission");
    private By healthCareRadioBtn1 = By.id("radio_program_medicare");
    private By healthCareRadioBtn2=By.id("radio_program_medicaid");
    private By healthCareRadioBtn3 =By.id("radio_program_none");
    private By visitDateField = By.id("txt_visit_date");
    private By commentField = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");
    private By appointmentForm = By.id("appointment");
    private By loginForm = By.id("login");


    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }


    public By getMakeAppointmentBtn() {
        return makeAppointmentBtn;
    }

    public By getAppointmentForm() {
        return appointmentForm;
    }

    public By getLoginForm() {
        return loginForm;
    }

    public By getFacilityBtn() {
        return facilityBtn;
    }

    public By getApplyForHospitalReadmissionBtn() {
        return applyForHospitalReadmissionBtn;
    }


    public By getVisitDateField() {
        return visitDateField;
    }

    public By getCommentField() {
        return commentField;
    }

    public By getBookAppointmentBtn() {
        return bookAppointmentBtn;
    }

    public By getAppointmentPage() {
        return appointmentForm;
    }


    public void enterMakeAppointmentPage() {
        getDriver().findElement(this.makeAppointmentBtn).click();
    }

    public boolean isFormPresented() {

        List<WebElement> elementList = getDriver().findElements(this.appointmentForm);

        if (elementList.isEmpty()) {
            getDriver().navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        }else{
        }
        return true;
    }

    public void applyForHospitalReadmission() {
        getDriver().findElement(this.applyForHospitalReadmissionBtn).click();
    }

    public void selectFacility() {
        Select selectFacility = new Select(getDriver().findElement(this.facilityBtn));
        for (int i = 0; i < 3; i++) {
            selectFacility.selectByIndex(i);
        }
    }

    public void chooseHealthCareProgram() {

            getDriver().findElement(healthCareRadioBtn1).click();
            getDriver().findElement(healthCareRadioBtn2).click();
            getDriver().findElement(healthCareRadioBtn3).click();
    }
     public void enterVisitDate(String visitDate){
         getDriver().findElement(this.visitDateField).sendKeys(visitDate);
     }

    public void enterComment(String comment){

        getDriver().findElement(this.commentField).sendKeys(comment);
    }

    public void clickBookAppointmentBtn(){
        getDriver().findElement(this.bookAppointmentBtn).click();
    }
}
