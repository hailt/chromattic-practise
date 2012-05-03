package org.exoplatform.example.chromattic.entities;
import org.chromattic.apt.Invoker;
import org.chromattic.apt.Instrumented;
public class Folder_Chromattic extends Folder implements Instrumented {
public final org.chromattic.spi.instrument.MethodHandler handler;
public Folder_Chromattic(org.chromattic.spi.instrument.MethodHandler handler) {
this.handler = handler;
}
private static final Invoker method_0 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"getGalleryMap");
protected final java.util.Map getGalleryMap() {
try {
return (java.util.Map)handler.invoke(this,method_0.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_1 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"getParent");
public final org.exoplatform.example.chromattic.entities.Folder getParent() {
try {
return (org.exoplatform.example.chromattic.entities.Folder)handler.invoke(this,method_1.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_2 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"createGallery");
protected final org.exoplatform.example.chromattic.entities.Gallery createGallery() {
try {
return (org.exoplatform.example.chromattic.entities.Gallery)handler.invoke(this,method_2.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_3 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"getName");
public final java.lang.String getName() {
try {
return (java.lang.String)handler.invoke(this,method_3.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_4 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"getPath");
public final java.lang.String getPath() {
try {
return (java.lang.String)handler.invoke(this,method_4.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_5 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Folder.class,"getId");
public final java.lang.String getId() {
try {
return (java.lang.String)handler.invoke(this,method_5.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
}
