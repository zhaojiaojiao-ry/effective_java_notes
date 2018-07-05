package Chapter1.service_and_provider.provider;

import Chapter1.service_and_provider.service.EnglishServiceImpl;
import Chapter1.service_and_provider.service.LanguageService;

public class SecondServiceProviderImpl implements LanguageServiceProvider{
    @Override
    public LanguageService newService() {
        return new EnglishServiceImpl();
    }
}
