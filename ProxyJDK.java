import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @className: ProxyJDK
 * @description: TODO
 * @author: carl
 * @date: 2021/9/14 17:29
 */
public class ProxyJDK {
    public static void main(String[] args) {
        SmsService service = (SmsService) ProxyFactory.getProxy(new SmsServiceImpl());
        service.send("JDK proxy");
    }
}

interface SmsService {
    String send(String message);
}

class SmsServiceImpl implements SmsService {

    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

class SmsInvocationHandler implements InvocationHandler {

    private Object proxyObject;

    public SmsInvocationHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke-method:"+method.getName());
        Object result = method.invoke(proxyObject, args);
        System.out.println("after invoke-method:"+method.getName());
        return result;
    }
}

class ProxyFactory {
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new SmsInvocationHandler(object));
    }
}
