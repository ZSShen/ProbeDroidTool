## Objective

Record the components launched from `android.app.Activity.startActivity()` and `android.app.Activity.startService()`.  


## Hierarchy
+ src
  + `AndroidManifest.xml` --- The source manifest of ComponentInspector.  
  + `build.gradle` --- The build script of ComponentInspector. 
  + `styles.xml` --- The resource definition of ComponentInspector.  
  + `ComponentInspector.java` --- The entry point of instrumentation package.  
  + `StartedActivity.java` --- The gadget to instrument android.app.Activity.startActivity()`.  
  + `StartedService.java` --- The gadget to instrument `android.app.Activity.startService()`.  

+ bin
  + `ComponentInspector.apk` --- The built package which can be directly pushed to device for experiment.  
  

