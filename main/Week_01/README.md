学习笔记

GC 调优的参数

-Xms4096m  //初始堆大小

-Xmx4096m  //最大堆大小

-Xmn1536m //新生代大小 eden + from + to

-Xss512K  //线程大小

-XX:NewRatio=2  //新生代和老年代的比例

-XX:MaxPermSize=64m   //持久代最大值

-XX:PermSize=16m  //持久代初始值

-XX:SurvivorRatio=8  // eden 区和survivor区的比例

-verbose:gc  

-Xloggc:gc.log  //输出gc日志文件

-XX:+UseGCLogFileRotation  //使用log文件循环输出

-XX:NumberOfGCLogFiles=1  //循环输出文件数量

-XX:GCLogFileSize=8k //日志文件大小限制

-XX:+PrintGCDateStamps //gc日志打印时间

-XX:+PrintTenuringDistribution            //查看每次minor GC后新的存活周期的阈值

-XX:+PrintGCDetails //输出gc明细

-XX:+PrintGCApplicationStoppedTime //输出gc造成应用停顿的时间

-XX:+PrintReferenceGC //输出堆内对象引用收集时间

-XX:+PrintHeapAtGC //输出gc前后堆占用情况



-XX:+UseParallelGC  //年轻代并行GC，标记-清除

-XX:+UseParallelOldGC //老年代并行GC，标记-清除

-XX:ParallelGCThreads=23 //并行GC线程数， cpu<=8?cpu:5*cpu/8+3

-XX:+UseAdaptiveSizePolicy //默认，自动调整年轻代各区大小及晋升年龄

-XX:MaxGCPauseMillis=15 //每次GC最大停顿时间,单位为毫秒

-XX:+UseParNewGC  //Serial多线程版

-XX:+UseConcMarkSweepGC  //CMS old gc

-XX:+UseCMSCompactAtFullCollection  //FullGC后进行内存碎片整理压缩

-XX:CMSFullGCsBeforeCompaction=n  //n次FullGC后执行内存整理

-XX:+CMSParallelRemarkEnabled  //启用并行重新标记,只适用ParNewGC

-XX:CMSInitiatingOccupancyFraction=80             //cms作为垃圾回收是，回收比例80%

-XX:ParallelGCThreads=23 //并行GC线程数，cpu<=8?cpu:5*cpu/8+3

-XX:-UseSerialGC //默认不启用，client使用时启用

-XX:+UseG1GC //启用G1收集器

-XX:-UseAdaptiveSizePolicy //默认，不自动调整各区大小及晋升年龄

-XX:PretenureSizeThreshold=2097152 //直接晋升到老年代的对象大小

-XX:MaxTenuringThreshold=15(default) //晋升到老年代的对象年龄，PSGen无效



-XX:-DisableExplicitGC //禁止在运行期显式地调用?System.gc() 

-XX:+HeapDumpOnOutOfMemoryError  //在OOM时输出堆内存快照

-XX:HeapDumpPath=./java_pid<pid>.hprof  //堆内存快照的存储路径 

-XX:+CMSScavengeBeforeRemark //执行CMS重新标记之前，尝试执行一此MinorGC

-XX:+CMSPermGenSweepingEnabled //开启永久代的并发垃圾收集




直接内存与物理内存

"zt.: 问下，直接内存和总的物理机内存的区别是什么"
- - - - - - - - - - - - - - -
直接内存是总的物理内存的一部分，直接内存是 java 通过 directByteBuffer 对象操作的，属于堆外内存



htt p请求的分配占用

「 丿追灬: @助教-小鱼哥 @助教-kris 一个http请求的字节数比线程栈设置的内存大会怎么样？ 」
- - - - - - - - - - - - - - -
这两个关系没这么大，请求的数据一般会分配到堆内存中，业务处理是由栈操作的，栈的大小和占内存有关系



☐ 请教一下各位：堆外内存和非堆内存的区别在哪里

非堆内存还是归jvm管（而且不是业务代码能涉及到的），
堆外内存一般是为了绕开gc直接使用的内存，业务代码特别是JNI用的，通常情况下是可能是非Java语言或者DirectBuffer里搞的。

比如说用C++写了一个lib库里面有个函数cppHello，这里面手动申请了内存，然后jvm调用，那么这个函数申请的内存，跟jvm的内存管理就没关系，但是在jvm进程里。



建议：

1、群里的问题有收集和追溯的路径，目前太零散
2、课程预习资料能早一点给到大家