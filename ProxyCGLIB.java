import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @className: ProxyCGLIB
 * @description: TODO
 * @author: carl
 * @date: 2021/9/15 1:51
 */
public class ProxyCGLIB {
    public static void main(String[] args) {
        ServiceImpl service = (ServiceImpl) CGLibProxyFactory.getProxy(ServiceImpl.class);
        service.sendSMS("java");
    }
}

interface Service {
    String sendSMS(String msg);
}

class ServiceImpl implements Service {

    @Override
    public String sendSMS(String msg) {
        System.out.println("send message: " + msg);
        return msg;
    }
}

class SMSMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method:" + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method:" + method.getName());
        return object;
    }
}

class CGLibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置需要被代理类
        enhancer.setSuperclass(clazz);
        //设置拦截增强
        enhancer.setCallback(new SMSMethodInterceptor());
        return enhancer.create();
    }
}


