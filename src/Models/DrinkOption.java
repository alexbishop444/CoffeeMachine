package Models;

public class DrinkOption {
    public DrinkOption(DrinkOptionType drinkOptionType, String question) {
        this.drinkOptionType = drinkOptionType;
        this.question = question;
    }

    private DrinkOptionType drinkOptionType;
    private String question;

    public DrinkOptionType getDrinkOptionType() {
        return drinkOptionType;
    }

    public void setDrinkOptionType(DrinkOptionType drinkOptionType) {
        this.drinkOptionType = drinkOptionType;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
