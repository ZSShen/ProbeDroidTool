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

package org.zsshen.classloaderinspector.DexClassLoader;

import android.util.Log;

import org.probedroid.support.MethodBundle;
import org.zsshen.classloaderinspector.ClassLoaderInspector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NewInstance extends MethodBundle {
    public NewInstance(boolean interceptBefore, boolean interceptAfter) {
        super(interceptBefore, interceptAfter);
    }

    @Override
    public void beforeMethodExecute(Object[] objects) {
        String pathDex = (String) objects[0];
        String dirOpt = (String) objects[1];
        String pathLib = (String) objects[2];
        ClassLoader loader = (ClassLoader) objects[3];

        StringBuffer sb = new StringBuffer();
        sb.append("Capture Dex File -> ");
        sb.append(pathDex);
        Log.d(ClassLoaderInspector.NAME_MODULE, sb.toString());

        try {
            File file = new File(pathDex);
            int len = (int) file.length();
            byte[] buf = new byte[len];
            FileInputStream in = new FileInputStream(pathDex);
            in.read(buf);
            ClassLoaderInspector.gMapDex.put(pathDex, buf);
            in.close();
        } catch (FileNotFoundException e) {
            Log.d(ClassLoaderInspector.NAME_MODULE, e.toString());
        } catch (IOException e) {
            Log.d(ClassLoaderInspector.NAME_MODULE, e.toString());
        }
    }

    @Override
    public void afterMethodExecute(Object object) {
    }
}
