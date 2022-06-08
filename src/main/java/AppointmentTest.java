import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class AppointmentTest {

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
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;
    private AppointmentPage appointmentForm;
    private AppointmentPage selectFacility;


    @BeforeClass

    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\GIT project\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);
    }

    @BeforeMethod

    public void beforeMethod() {
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
    }

    @AfterClass
    public void afterClass() {

        driver.close();
    }

    @Test(priority = 1)

    private void testLogin() {
        loginPage.enterLoginPage();
        loginPage.enterUserName("John Doe");
        loginPage.enterPassword("ThisIsNotAPassword");
        loginPage.login();
        Assert.assertTrue(appointmentPage.isFormPresented(), "true");
    }

    @Test(priority = 2)

    private void testMakingAnAppointment() {
        try {
            appointmentPage.enterMakeAppointmentPage();
            appointmentPage.selectFacility();
            appointmentPage.applyForHospitalReadmission();
            appointmentPage.chooseHealthCareProgram();
            appointmentPage.enterVisitDate("30/06/2022");
            appointmentPage.enterComment("abc");
            appointmentPage.clickBookAppointmentBtn();

            Thread.sleep(5000);

            Assert.assertTrue(driver.findElement(summaryPage.getAppointmentConfirmationMessage()).getText().contains("Please be informed that your appointment has been booked as following:"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)

    private void testSummaryPageIsCompatibleWithAppointmentPage() {
        try {
            Assert.assertEquals(driver.findElement(summaryPage.getFacilityAppointmentConfirmation()).getText(), driver.findElement(appointmentPage.getFacilityBtn()).getText());
            Thread.sleep(5000);

            Assert.assertTrue(driver.findElement(appointmentPage.getApplyForHospitalReadmissionBtn()).isSelected());
            Assert.assertEquals(driver.findElement(summaryPage.getVisitDateAppointmentConfirmation()).getText(), driver.findElement(appointmentPage.getVisitDateField()).getText());
            Assert.assertEquals(driver.findElement(summaryPage.getCommentAppointmentConfirmation()).getText(), driver.findElement(appointmentPage.getCommentField()).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}