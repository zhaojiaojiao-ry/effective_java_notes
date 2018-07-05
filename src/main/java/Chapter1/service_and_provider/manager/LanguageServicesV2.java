package Chapter1.service_and_provider.manager;

import Chapter1.service_and_provider.provider.LanguageServiceProvider;
import Chapter1.service_and_provider.service.LanguageService;

import java.util.concurrent.ConcurrentHashMap;

public class LanguageServicesV2 {
    // service-services
    // 简单工厂模式
    // 通过反射，每次实例化新的service对象

    // 保存定义的service类名
    private static final ConcurrentHashMap<String, String> services = new ConcurrentHashMap<>();

    // 初始化，从配置加载，保存service类名
    static {
        String[] servicesConf = {"chinese:Chapter1.service_and_provider.service.ChineseServiceImpl",
                "english:Chapter1.service_and_provider.service.EnglishServiceImpl"};
        for (int i=0; i<servicesConf.length; i++) {
            String[] pair = servicesConf[i].split(":");
            if (pair.length == 2) {
                String name = pair[0];
                String className = pair[1];
                services.put(name, className);
            }
        }
    }

    // 指定service，获得新的service实例
    public static LanguageService newLanguageService (String name) {
        if (services.containsKey(name)) {
            String className = services.get(name);
            try {
                Class clazz = Class.forName(className);
                return (LanguageService) clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
