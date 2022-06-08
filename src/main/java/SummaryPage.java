import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{
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
private By appointmentConfirmationMessage=By.xpath("//*[@id=\"summary\"]/div/div/div[1]/p");
private By facilityAppointmentConfirmation=By.id("facility");
private By applyForHospitalReadmissionAppointmentConfirmation=By.id("hospital_readmission");
private By healthCareProgramAppointmentConirmation=By.id("program");
private By visitDateAppointmentConfirmation=By.id("visit_date");
private By commentAppointmentConfirmation=By.id("comment");
private By goToHomepageBtn=By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getAppointmentConfirmationMessage() {
        return appointmentConfirmationMessage;
    }

    public By getFacilityAppointmentConfirmation() {
        return facilityAppointmentConfirmation;
    }

    public By getApplyForHospitalReadmissionAppointmentConfirmation() {
        return applyForHospitalReadmissionAppointmentConfirmation;
    }

    public By getHealthCareProgramAppointmentConirmation() {
        return healthCareProgramAppointmentConirmation;
    }

    public By getVisitDateAppointmentConfirmation() {
        return visitDateAppointmentConfirmation;
    }

    public By getCommentAppointmentConfirmation() {
        return commentAppointmentConfirmation;
    }

    public By getGoToHomepageBtn() {
        return goToHomepageBtn;
    }
}


