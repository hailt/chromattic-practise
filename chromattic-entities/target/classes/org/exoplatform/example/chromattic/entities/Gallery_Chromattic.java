package org.exoplatform.example.chromattic.entities;
import org.chromattic.apt.Invoker;
import org.chromattic.apt.Instrumented;
public class Gallery_Chromattic extends Gallery implements Instrumented {
public final org.chromattic.spi.instrument.MethodHandler handler;
public Gallery_Chromattic(org.chromattic.spi.instrument.MethodHandler handler) {
this.handler = handler;
}
private static final Invoker method_0 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Gallery.class,"getPhotoMap");
public final java.util.Map getPhotoMap() {
try {
return (java.util.Map)handler.invoke(this,method_0.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_1 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Gallery.class,"getName");
public final java.lang.String getName() {
try {
return (java.lang.String)handler.invoke(this,method_1.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_2 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Gallery.class,"getPath");
public final java.lang.String getPath() {
try {
return (java.lang.String)handler.invoke(this,method_2.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_3 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Gallery.class,"createPhoto");
public final org.exoplatform.example.chromattic.entities.Photo createPhoto() {
try {
return (org.exoplatform.example.chromattic.entities.Photo)handler.invoke(this,method_3.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
}
