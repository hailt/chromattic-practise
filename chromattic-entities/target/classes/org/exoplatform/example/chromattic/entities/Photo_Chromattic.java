package org.exoplatform.example.chromattic.entities;
import org.chromattic.apt.Invoker;
import org.chromattic.apt.Instrumented;
public class Photo_Chromattic extends Photo implements Instrumented {
public final org.chromattic.spi.instrument.MethodHandler handler;
public Photo_Chromattic(org.chromattic.spi.instrument.MethodHandler handler) {
this.handler = handler;
}
private static final Invoker method_0 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getContent");
public final org.exoplatform.example.chromattic.entities.Content getContent() {
try {
return (org.exoplatform.example.chromattic.entities.Content)handler.invoke(this,method_0.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_1 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getParent");
public final org.exoplatform.example.chromattic.entities.Gallery getParent() {
try {
return (org.exoplatform.example.chromattic.entities.Gallery)handler.invoke(this,method_1.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_2 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"createContent");
protected final org.exoplatform.example.chromattic.entities.Content createContent() {
try {
return (org.exoplatform.example.chromattic.entities.Content)handler.invoke(this,method_2.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_3 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getCreated");
public final java.util.Date getCreated() {
try {
return (java.util.Date)handler.invoke(this,method_3.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_4 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"setContent",org.exoplatform.example.chromattic.entities.Content.class);
public final void setContent(org.exoplatform.example.chromattic.entities.Content arg_0) {
try {
handler.invoke(this,method_4.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_5 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getName");
public final java.lang.String getName() {
try {
return (java.lang.String)handler.invoke(this,method_5.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_6 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getPath");
public final java.lang.String getPath() {
try {
return (java.lang.String)handler.invoke(this,method_6.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_7 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"setName",java.lang.String.class);
public final void setName(java.lang.String arg_0) {
try {
handler.invoke(this,method_7.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_8 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Photo.class,"getId");
public final java.lang.String getId() {
try {
return (java.lang.String)handler.invoke(this,method_8.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
}
