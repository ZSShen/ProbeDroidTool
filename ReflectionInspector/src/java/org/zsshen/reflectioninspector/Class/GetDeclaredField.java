package org.zsshen.reflectioninspector.Class;


import android.util.Log;

import org.probedroid.support.MethodBundle;
import org.zsshen.reflectioninspector.ReflectionInspector;

import java.lang.reflect.Field;

public class GetDeclaredField extends MethodBundle {
    public GetDeclaredField(boolean interceptBefore, boolean interceptAfter) {
        super(interceptBefore, interceptAfter);
    }

    @Override
    public void beforeMethodExecute(Object[] objects) {
        String nameField = objects[0].toString();
        //Log.d(ReflectionInspector.NAME_MODULE, nameField);
    }

    @Override
    public void afterMethodExecute(Object o) {
        Field field = (Field) o;
        //Log.d(ReflectionInspector.NAME_MODULE, field.toString());
    }
}
