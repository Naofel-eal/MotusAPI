package src.main.java.com.naofeleal.MotusAPI.Interfaces.Web.DTOs;

public class OutputWordDTO {
    public String value;
    public String languageCode;

    public OutputWordDTO(String value, String languageCode) {
        this.value = value;
        this.languageCode = languageCode;
    }
}
