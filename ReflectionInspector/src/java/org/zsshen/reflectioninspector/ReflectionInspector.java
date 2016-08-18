package org.zsshen.reflectioninspector;


import android.util.Log;

import org.probedroid.Instrument;
import org.zsshen.reflectioninspector.Class.GetDeclaredField;
import org.zsshen.reflectioninspector.Class.GetDeclaredMethod;

public class ReflectionInspector extends Instrument {
    public static final String NAME_MODULE = "ReflectionInspector";

    @Override
    public void onApplicationStart() {
        String nameClass = "java.lang.Class";
        String nameMethod = "getDeclaredField";
        String signatureMethod =
                "(Ljava/lang/String;)Ljava/lang/reflect/Field;";
        GetDeclaredField fieldResolver = new GetDeclaredField(true, true);
        try {
            instrumentMethod(false, nameClass, nameMethod, signatureMethod,
                    fieldResolver);
        } catch (IllegalArgumentException e) {
            Log.d(NAME_MODULE, e.toString());
        } catch (ClassNotFoundException e) {
            Log.d(NAME_MODULE, e.toString());
        } catch (NoSuchMethodException e) {
            Log.d(NAME_MODULE, e.toString());
        }

        nameClass = "java.lang.Class";
        nameMethod = "getDeclaredMethod";
        signatureMethod =
                "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;";
        GetDeclaredMethod getMethod = new GetDeclaredMethod(true, true);
        try {
            instrumentMethod(false, nameClass, nameMethod, signatureMethod, getMethod);
        } catch (IllegalArgumentException e) {
            Log.d(NAME_MODULE, e.toString());
        } catch (ClassNotFoundException e) {
            Log.d(NAME_MODULE, e.toString());
        } catch (NoSuchMethodException e) {
            Log.d(NAME_MODULE, e.toString());
        }
    }

    @Override
    public void onApplicationStop() {

    }
}
