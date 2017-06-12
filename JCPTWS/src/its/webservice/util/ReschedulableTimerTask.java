package its.webservice.util;
import java.lang.reflect.Field;
import java.util.TimerTask;


public abstract class ReschedulableTimerTask  extends TimerTask {   
    public void setPeriod(long period) {   
        setDeclaredField(TimerTask.class, this, "period", period);    //�޸Ķ�ʱ��ִ��ʱ������
    }   
       
    static boolean setDeclaredField(Class<?> clazz, Object obj,   
            String name, Object value) {   //  ͨ�������޸��ֶε�ֵ   
        try {   
            Field field = clazz.getDeclaredField(name);   
            field.setAccessible(true);   
            field.set(obj, value);   
            return true;   
        } catch (Exception ex) {   
            ex.printStackTrace();   
            return false;   
        }   
    }

}
