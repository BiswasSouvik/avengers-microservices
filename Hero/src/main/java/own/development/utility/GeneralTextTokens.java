package own.development.utility;

public enum GeneralTextTokens {
    HERO_NOT_FOUND_ID("Sorry! No Hero exists with this ID : "),
    HERO_NOT_FOUND_NAME("Sorry! No Hero exists with this Name : "),

    DELETED_HERO_ID("Deleted Hero with ID : "),
    DELETED_HERO_NAME("Deleted Hero with Name : ");

    private final String property;

    GeneralTextTokens(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    private String getText() {return property;}
}
