#  第一章 Activity的生命周期和启动模式

## 1.1 生命周期详解
   &emsp;&emsp;Activity是用户最常见的组件，是程序最直观的体检，Activity的生命周期伴随的Activity的活动状态的变化而变化，开发者可以利用这些变化，做出相应的处理。
### 1.1.1 正常情况下的Activity生命周期
   &emsp;&emsp;正常情况下，Activity会经历如下生命周期。 
    
   &emsp;&emsp;(1) **onCreat：** Activity正在被创建，是生命周期的第一个方法，可以执行一些初始化的工作。一般只会执行一次。
   
   &emsp;&emsp;(2) **onReStart：**  Activity重新被启用，一般是Activity从不可见到可见的时候被调用，例如用户按Home键切换到桌面，又回到当前Activity的时候。
   
   &emsp;&emsp;(3) **onStart：**  Activity 正在被启用，当前Activity可见，但是不可跟用户交互。紧接着会执行onResume.
   
   &emsp;&emsp;(4) **onResume：**  Activity 已经可见了。并且用户可以跟它交互了。
   
   &emsp;&emsp;(5) **onPause：**  Activity正在停止，紧接着会执行onStop.此时可以做一些存储数据，停止动画等操作，为了不影响页面的流畅，不可执行太耗时的操作，因为只有当前Activity的onPause执行完了之后，新的Activity的onResume才会执行。
   
   &emsp;&emsp;(6) **onStop：**  Activity即将停止，可以做一下稍微重量级一点的操作，但是不能太耗时。此时Activity完全不可见。
   
   &emsp;&emsp;(7) **onDestory：** Activity即将被销毁，可以做一些回收工作和资源释放。  
   正常情况下，Activity常用的生命周期就是7个，完整的流程图如下：
   ![生命周期切换图](http://hi.csdn.net/attachment/201007/28/0_12803210018q71.gif)
   总结起来，Activity的生命流程有一下几种情况：  
   
   (1) Activity第一次启动，回调如下：onCreat->onStart->onResume.  
   
   (2) 当用户切换到其他Activity或按Home切换到桌面的时候，onPause->onStop.这时有一个特例，就是新的Activity采用了透明的主题，则只会回调 onPause,因为原Activity不会完全不可见。  
   
   (3) 当用户回到原Activity,回调：onRestart->onStart->onResume.  
   
   (4）当用户按back键回退时，回调如下：onPause->onStop->onDestory.  
   
   (5) 从整个生命周期来看，onCreat和onDestory是配对的，分别标识Activity的创建和销毁，只可能调用一次。从Activity是否可见，onStart和onStop 是配对的，可执行多次。从Activity是否在前台，也就是可交互，onResume和onPause是配对的，也可执行多次。  
   
   (6) 当打开一个新的Activity的时候，先执行原Activity的onPause,然后在执行新Activity的onResume.  
   
   
### 1.1.2 不正常情况下的生命周期
 &emsp;&emsp; 当资源相关的系统配置发生改变或系统内存不足的时候，Activity可能会被杀死，发生不正下情况的生命周期回调，Activity会被销毁，然后重新创建一个新的Activity，Activity被销毁的时候，onPause,onStop,onDestory都会被调用，创建新的Activity的时候，onCreat,onStart,onResume也都会被调用。当然，在这期间，还是会有一些新的回调的。在Activity被销毁的时候，在onStop之前，系统会调用onSaveInstanceState来保存当前的Activity的状态。在新建Activity的时候，在onStart之后，会调用onRestoreInstanceState取出之前在onSaveInstanceState中所保存的Bundle数据。  
 &emsp;&emsp;当在AndroidMenifest.xml中Activity的属性中配置configChange属性时，当系统配置发生变化时，不会重新创建Activity。
   

## 1.2 Activity的启动模式
### 1.2.2 启动模式
&emsp;&emsp; 在讲Activity的启动模式之前，首先要了解任务栈。任务栈是一种“后进先出”的栈结构，系统创建一个Activity实例，就会让新的Activity入栈，每销毁一个Activity也会让该Activity实例出栈。  

*``注意：``非Activity的Context没有所谓的任务栈，用它启动Activity必须指定Intent.FLAG_ACTIVITY_NEW_TASK标记位，这样启动会创建一个新的任务栈,方法如下*  

``` android
Intent intent=new Intent();
intent.setClass(MainActivity.this, Main2Activity.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
getApplicationContext().startActivity(intent);
```  
(1) **standard :** 标准模式，也是系统默认的启动模式。每启动一个Activity都会新建一个实例，放入栈中。谁启动的这个Activity，新建的Activity实例就会放入启动它的那个Activity所在的栈中。当有Intent.FLAG_ACTIVITY_NEW_TASK标记位时，系统会创建一个新的任务栈。  

(2) **singleTop :** 栈顶复用模式。当要启动的Activity位于启动该Activity的任务栈的栈顶，此时不会新建一个Activity实例，只会调用onNewIntent方法，并且onCreat，onStart不会被调用。当要启动的Activity不是位于启动该Activity的任务栈的栈顶，则会新建一个新的Activity实例。  

(3) **singleTask :** 栈内复用模式。这是一种单例模式，只要Activity在一个任务栈中存在，多次启动改Activity都不会创建新的Activity。系统会调用onNewIntent, onRestart->onStart->onResume.

*``注意：`` singleTask默认具有clearTop的效果 例如：Activity D 需要的任务栈是s ,s中的情况是ADBC ,启动D时，不会创建新的D，会把D切换到栈顶，但是会把D上面的实例出栈，此时S的情况是AD*  

(4) **singleInstance :** 单实例模式。具有此模式的Activity只能单独的位于一个独立的任务栈。  

*``注意`` 可以用adb shell dumpsys activity 命令查看任务栈情况*  
 
### 1.2.2 Activity的Frag
* Intent.FLAG_ACTIVITY_NEW_TASK ：相当于 XML中的singleTask 模式。
* Intent.FLAG_ACTIVITY_SINGLE_TOP : 相当于 XML中的singleTop 模式。
* Intent.FLAG_ACTIVITY_CLEAR_TOP :启动此标记的Activity时，同一任务栈中所有位于它上面的Activity都要出栈。  
  
## 1.3 IntentFilter 匹配规则






