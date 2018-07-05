package Chapter2.service_and_provider.provider;

import Chapter2.service_and_provider.service.LanguageService;

// 语言服务生成器，接口
public interface LanguageServiceProvider {
    // 每次调用产生一个新的LanguageService
    LanguageService newService();
}
