package cxc.launcher.myClassLoader;

import java.io.FileInputStream;

/**
 * @ClassName:MyClassLoader
 * @DESCRIPTION:
 * @author: cxc
 * @DATE: 2021/4/3
 */

public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader( String path) {
        this.path = path;
    }
    private byte[] loadByte(String name) throws Exception {
         name = name.replaceAll("\\.", "/");
         FileInputStream fis = new FileInputStream(path + "/" + name + ".class");
         int len = fis.available();
         byte[] data = new byte[len];
         fis.read(data);
         fis.close();
         return data;
    }


    @Override
    protected Class<?> findClass( String name)
            throws ClassNotFoundException
    {
        try {
            byte[] bytes = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }

    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
               //双亲委派的核心代码
               /* try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }*/

                //不委派双亲直接调用自身的findClass方法
                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    if (name.startsWith("cxc.launcher.classLoad")) {
                        c = findClass(name);
                    }else {
                        //核心类和扩展类还是要由jvm自己的类加载器进行加载
                        c = this.getParent().loadClass(name);
                    }

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

}
