## Objective

Record the fields and methods resolved from `java.lang.reflect.*` related methods.  


## Hierarchy
+ src
  + `AndroidManifest.xml` --- The source manifest of ReflectionInspector.  
  + `build.gradle` --- The build script of ReflectionInspector. 
  + `styles.xml` --- The resource definition of ReflectionInspector.  
  + `ReflectionInspector.java` --- The entry point of instrumentation package.  
  + Class package
    + `GetDeclaredField.java` --- The gadget to instrument `Class.getDeclaredField(String)`.  
    + `GetDeclaredMethod.java` --- The gadget to instrument `Class.getDeclaredMethod(String, Class[])`.  

+ bin
  + `ReflectionInspector.apk` --- The built package which can be directly pushed to device for experiment.  
  

