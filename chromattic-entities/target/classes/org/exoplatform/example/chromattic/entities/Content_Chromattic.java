package org.exoplatform.example.chromattic.entities;
import org.chromattic.apt.Invoker;
import org.chromattic.apt.Instrumented;
public class Content_Chromattic extends Content implements Instrumented {
public final org.chromattic.spi.instrument.MethodHandler handler;
public Content_Chromattic(org.chromattic.spi.instrument.MethodHandler handler) {
this.handler = handler;
}
private static final Invoker method_0 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"getEncoding");
public final java.lang.String getEncoding() {
try {
return (java.lang.String)handler.invoke(this,method_0.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_1 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"setData",java.io.InputStream.class);
public final void setData(java.io.InputStream arg_0) {
try {
handler.invoke(this,method_1.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_2 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"setEncoding",java.lang.String.class);
public final void setEncoding(java.lang.String arg_0) {
try {
handler.invoke(this,method_2.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_3 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"getPhoto");
public final org.exoplatform.example.chromattic.entities.Photo getPhoto() {
try {
return (org.exoplatform.example.chromattic.entities.Photo)handler.invoke(this,method_3.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_4 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"setMimeType",java.lang.String.class);
public final void setMimeType(java.lang.String arg_0) {
try {
handler.invoke(this,method_4.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_5 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"getData");
public final java.io.InputStream getData() {
try {
return (java.io.InputStream)handler.invoke(this,method_5.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_6 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"getLastModified");
public final java.util.Date getLastModified() {
try {
return (java.util.Date)handler.invoke(this,method_6.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_7 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"setLastModified",java.util.Date.class);
public final void setLastModified(java.util.Date arg_0) {
try {
handler.invoke(this,method_7.getMethod(),(Object)arg_0);
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
private static final Invoker method_8 = Invoker.getDeclaredMethod(org.exoplatform.example.chromattic.entities.Content.class,"getMimeType");
public final java.lang.String getMimeType() {
try {
return (java.lang.String)handler.invoke(this,method_8.getMethod());
} catch(Throwable t) {
if (t instanceof java.lang.RuntimeException) throw (java.lang.RuntimeException)t;
if (t instanceof java.lang.Error) throw (java.lang.Error)t;
throw new java.lang.reflect.UndeclaredThrowableException(t);
}
}
}
