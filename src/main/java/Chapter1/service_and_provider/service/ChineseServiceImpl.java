package Chapter1.service_and_provider.service;

public class ChineseServiceImpl implements LanguageService {
    @Override
    public String hello() {
        return "你好";
    }
}
