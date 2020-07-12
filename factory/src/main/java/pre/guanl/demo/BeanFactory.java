package pre.guanl.demo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    public void addBeanDefinition(List<BeanDefinition> beanDefinitionList) {
        //  beanDefinitionMap 管理所有的bean
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitionMap.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            // 如果不是懒加载，且bean的范围是单例，则提前初始化bean
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {
        // 如果是单例对象，且已经创建过该对象，则直接从缓存map中获取单例对象
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }
        Object bean = null;
        try {
            // 根据全限定类名获取类对象
            Class beanClass = Class.forName(beanDefinition.getClassName());
            // 获取bean 的参数列表
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgList();
            if (args.isEmpty()) {
                // 参数列表为空，则调用无参构造方法创建对象
                bean = beanClass.newInstance();
            } else {
                Class[] argClasses = new Class[args.size()];
                Object[] argObjects = new Object[args.size()];
                for (int i = 0; i < args.size(); i++) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    // 如果参数不是引用其他bean对象
                    if (!arg.isRef()) {
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    } else {
                        BeanDefinition refBeanDefinition = beanDefinitionMap.get(arg.getArg().toString());
                        if (refBeanDefinition == null) {
                            throw new RuntimeException("bean is not defined");
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                // 通过调用有参构造方法创建对象
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (beanDefinition == null) {
            throw new RuntimeException("bean is not defined");
        }
        return createBean(beanDefinition);
    }

    public static void main(String[] args) {
        BeanDefinition.ConstructorArg constructorArg = new BeanDefinition.ConstructorArg
                .Builder()
                .setRef(false)
                .setType(String.class)
                .setArg("test").build();
        System.out.println(constructorArg);
    }
}
