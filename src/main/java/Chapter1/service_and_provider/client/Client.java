package Chapter1.service_and_provider.client;

import Chapter1.service_and_provider.manager.LanguageServicesV1;
import Chapter1.service_and_provider.manager.LanguageServicesV2;
import Chapter1.service_and_provider.service.LanguageService;

public class Client {
    public static void main(String[] args) {

        /*
        String[] providers = {"chinese:FirstServiceProviderImpl", "english:SecondServiceProviderImpl"};
        for (int i=0; i<providers.length; i++) {
            String[] pair = providers[i].split(":");
            if (pair.length == 2) {
                String name = pair[0];
                String className = pair[1];
                try {
                    Class clazz = Class.forName(className);
                    LanguageServicesV1.registerProvider(name, (LanguageServiceProvider) clazz.newInstance());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }
        }
        */
        // 从配置读取provider名称和类名
        // 通过反射获得provider实例，注册到LanguageServicesV1
        // 客户端决定获得哪种service实例
        LanguageService chinese = LanguageServicesV1.newLanguageService("chinese");
        LanguageService english = LanguageServicesV1.newLanguageService("english");
        if (chinese != null) {
            System.out.println(chinese.hello());
        }
        if (english != null) {
            System.out.println(english.hello());
        }

        // 从配置读取service名称和类名
        // 配置信息保存到LanguageServicesV2
        // 客户端决定获得哪种service实例，通过反射获得service实例
        LanguageService chineseV2 = LanguageServicesV2.newLanguageService("chinese");
        LanguageService englishV2 = LanguageServicesV2.newLanguageService("english");
        if (chineseV2 != null) {
            System.out.println(chineseV2.hello());
        }
        if (englishV2 != null) {
            System.out.println(englishV2.hello());
        }

        // 可以看到两种方法从客户端看是一样的
    }
}
