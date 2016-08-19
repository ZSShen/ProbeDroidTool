/**
 *   The MIT License (MIT)
 *   Copyright (C) 2016 ZongXian Shen <andy.zsshen@gmail.com>
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a
 *   copy of this software and associated documentation files (the "Software"),
 *   to deal in the Software without restriction, including without limitation
 *   the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *   and/or sell copies of the Software, and to permit persons to whom the
 *   Software is furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 *   THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 *   IN THE SOFTWARE.
 */

package org.zsshen.classloaderinspector;


import android.util.Log;

import org.probedroid.Instrument;
import org.zsshen.classloaderinspector.DexClassLoader.NewInstance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class ClassLoaderInspector extends Instrument {

    public static final String NAME_MODULE = "ClassLoaderInspector";
    public static HashMap<String, byte[]> gMapDex;

    @Override
    public void onApplicationStart() {
        gMapDex = new HashMap<>();

        String nameClass = "dalvik.system.DexClassLoader";
        String nameMethod = "<init>";
        String signatureMethod =
                "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V";
        NewInstance newInstance = new NewInstance(true, true);
        try {
            instrumentMethod(false, nameClass, nameMethod, signatureMethod,
                    newInstance);
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
        for (String pathDex : gMapDex.keySet()) {
            File fileIn = new File(pathDex);
            String nameDex = fileIn.getName();
            File fileOut = new File(mPathOutputDirectory, nameDex);
            byte[] payload = gMapDex.get(pathDex);
            try {
                FileOutputStream out = new FileOutputStream(fileOut.getPath());
                out.write(payload);
                out.close();
            } catch (FileNotFoundException e) {
                Log.d(ClassLoaderInspector.NAME_MODULE, e.toString());
            } catch (IOException e) {
                Log.d(ClassLoaderInspector.NAME_MODULE, e.toString());
            }
        }
    }
}
