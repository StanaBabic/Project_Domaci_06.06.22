import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
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

private By menuBtn=By.id("menu-toggle");
private By enterLoginPageBtn=By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");
private By userName=By.id("txt-username");
private By password=By.id("txt-password");
private By loginBtn=By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void enterLoginPage(){
        getDriver().findElement(menuBtn).click();
        getDriver().findElement(enterLoginPageBtn).click();

    }

    public void enterUserName(String userName){
       getDriver().findElement(this.userName).sendKeys(userName);
    }

    public void enterPassword(String password){
        getDriver().findElement(this.password).sendKeys(password);
    }

    public void login(){
        getDriver().findElement(loginBtn).click();
    }
}
