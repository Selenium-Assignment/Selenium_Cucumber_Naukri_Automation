package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    WebDriver ldriver;



    public  HomePage(WebDriver rdriver){
        this.ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    private @FindBy(xpath="(//a[@href='/mnjuser/profile'])[1]")
    WebElement viewprofile;

    public void accountHolderProfile(){
        viewprofile.click();
    }


    private @FindBy(xpath ="//span[text()='Resume headline']//following-sibling::span[contains(text(),'editOneTheme')]")
    WebElement Resume_headline;

    public void editresumeHeadlineSection(){
        Resume_headline.click();
    }
    private @FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']")
    WebElement resumeHeadline_InputArea;

    public void resumeHeadlineTxt(String resume_txt){
        resumeHeadline_InputArea.click();
        resumeHeadline_InputArea.clear();
        resumeHeadline_InputArea.sendKeys(resume_txt);
    }

    private @FindBy(xpath="//div[@class='action s12']//child::button")
    WebElement resumeHeadline_saveButton;
    public void saveButtonResumeHeadlineText(){
        resumeHeadline_saveButton.click();
    }


    //***************** ********updating Key_Skills Sections **********************************

    private @FindBy(xpath="//span[text()='Key skills']//following-sibling::span[contains(text(),'editOneTheme')]")
    WebElement KeySkillEditButton;

    public void UpdateKeySkill() throws InterruptedException {
        List<WebElement> keySkills = ldriver.findElements(By.xpath("(//div[@class='prefill'])[1]/span"));
        List<String> skilllist = new ArrayList<>();
        for(WebElement skills: keySkills){
            skilllist.add(skills.getAttribute("title"));
        }
        KeySkillEditButton.click();
        Thread.sleep(3000);
       WebElement crossButton = ldriver.findElement(By.xpath("//span[text()='SQL']//following-sibling::a"));
       crossButton.click();
       WebElement skillDropDown = ldriver.findElement(By.xpath("//input[@id='keySkillSugg']"));
       skillDropDown.click();
       skillDropDown.sendKeys("SQL");
       Thread.sleep(1000);
       List<WebElement> dropDownOPtions = ldriver.findElements(By.xpath("//li[@class ='sugTouple']"));
       for(WebElement option : dropDownOPtions){
           String preferedOption = option.getText();
           if(preferedOption.contains("SQL")){
               option.click();
               break;
           }
       }

       ldriver.findElement(By.xpath("//button[@id ='saveKeySkills']")).click();
    }




    private@FindBy(xpath ="(//p[@class='msg'])")
    WebElement updadationSuccessfulMgs;

    public String updadationSuccessfulMgs(){
        String mgs =updadationSuccessfulMgs.getText();
        return mgs;
    }

}
