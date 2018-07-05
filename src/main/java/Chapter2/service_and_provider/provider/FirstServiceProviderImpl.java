package Chapter2.service_and_provider.provider;

import Chapter2.service_and_provider.service.ChineseServiceImpl;
import Chapter2.service_and_provider.service.LanguageService;

public class FirstServiceProviderImpl implements LanguageServiceProvider {
    @Override
    public LanguageService newService() {
        return new ChineseServiceImpl();
    }
}
