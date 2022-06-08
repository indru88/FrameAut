package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchField = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]";
    private String firstResult = "";
    public GooglePage(){
        super(driver);
    }
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
    public void searchCriteria(String text){
        write(searchField, text);
    }
    public void clickToSearch(){
        clickElement(searchButton);
    }
    public String firstResult(){
        return textFromElement(firstResult);
    }
}
