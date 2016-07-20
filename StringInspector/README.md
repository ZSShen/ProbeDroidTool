## Objective

Record the string objects coverted from `StringBuffer.toString()` and `StringBuilder.toString()`.  


## Hierarchy
+ src
  + `AndroidManifest.xml` --- The source manifest of StringInspector.  
  + `build.gradle` --- The build script of StringInspector. 
  + `styles.xml` --- The resource definition of StringInspector.  
  + `StringInspector.java` --- The entry point of instrumentation package.  
  + `ConvertedStringBuffer.java` --- The gadget to instrument `StringBuffer.toString()`.  
  + `ConvertedStringBuilder.java` --- The gadget to instrument `StringBuilder.toString()`.  

+ bin
  + `StringInspector.apk` --- The built package which can be directly pushed to device for experiment.  
  

