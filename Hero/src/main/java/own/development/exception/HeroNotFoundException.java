package own.development.exception;

import own.development.utility.GeneralTextTokens;

public class HeroNotFoundException extends RuntimeException {

    public HeroNotFoundException(Long id) {
        super(GeneralTextTokens.HERO_NOT_FOUND_ID.getProperty() + id);
    }

    public HeroNotFoundException(String name) {
        super(GeneralTextTokens.HERO_NOT_FOUND_NAME.getProperty() + name);
    }
}
