package org.zsshen.reflectioninspector.Class;


import android.util.Log;

import org.probedroid.support.MethodBundle;
import org.zsshen.reflectioninspector.ReflectionInspector;

import java.lang.reflect.Method;

public class GetMethod extends MethodBundle{

    public GetMethod(boolean interceptBefore, boolean interceptAfter) {
        super(interceptBefore, interceptAfter);
    }

    @Override
    public void beforeMethodExecute(Object[] objects) {
        StringBuffer sb = new StringBuffer();

        String nameMethod = objects[0].toString();
        sb.append(nameMethod);

        Class[] signatureList = (Class[]) objects[1];
        sb.append("(");
        boolean isCat = false;
        for (Class clazz : signatureList) {
            sb.append(clazz.getName());
            sb.append(", ");
            isCat = true;
        }
        if (isCat) {
            int len = sb.length();
            sb.delete(len - 2, len);
        }
        sb.append(")");

        Log.d(ReflectionInspector.NAME_MODULE, sb.toString());
    }

    @Override
    public void afterMethodExecute(Object o) {
        Method method = (Method) o;
        Log.d(ReflectionInspector.NAME_MODULE, method.toString());
    }
}
