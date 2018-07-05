package Chapter2.service_and_provider.manager;

import Chapter2.service_and_provider.provider.LanguageServiceProvider;
import Chapter2.service_and_provider.service.LanguageService;

import java.util.concurrent.ConcurrentHashMap;

public class LanguageServicesV1 {
    // service-provider-services
    // 区别于service-services结构，增加了provider层
    // 如果1个service只能有一种provider，那用service-services结构就足够了，见LanguageServicesV2
    // 如果1个service可以通过多种provider实现，比如JDBC连接可以通过多种驱动创建，那么就需要service-provider-services模式

    // 保存注册的providers
    // 适合于每种provider只实例一个对象，但可以用一个provider对象实例出多个service对象
    private static final ConcurrentHashMap<String, LanguageServiceProvider> providers = new ConcurrentHashMap<>();

    // 初始化，从配置加载，注册provider
    static {
        String[] providersConf = {"chinese:Chapter2.service_and_provider.provider.FirstServiceProviderImpl",
                "english:Chap" +
                        "ter1.service_and_provider.provider.SecondServiceProviderImpl"};
        for (int i=0; i<providersConf.length; i++) {
            String[] pair = providersConf[i].split(":");
            if (pair.length == 2) {
                String name = pair[0];
                String className = pair[1];
                try {
                    Class clazz = Class.forName(className);
                    registerProvider(name, (LanguageServiceProvider) clazz.newInstance());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    // 负责注册provider
    private static boolean registerProvider(String name, LanguageServiceProvider provider) {
        if (providers.containsKey(name)) {
            return false;
        }
        providers.put(name, provider);
        return true;
    }

    // 指定provider，获得新的service实例
    public static LanguageService newLanguageService (String name) {
        if (providers.containsKey(name)) {
            LanguageServiceProvider provider = providers.get(name);
            return provider.newService();
        }
        return null;
    }
}
