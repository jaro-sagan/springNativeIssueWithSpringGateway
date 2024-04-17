# A sample to show issue with Spring Native and Spring Gateway

### Steps to reproduce:
- build a native image `mvn -Pnative spring-boot:build-image`
- start the image `docker run --rm -p 8090:8090 docker.io/library/native-demo:0.0.1-SNAPSHOT`
- access `http://localhost:8090/`
- check the logs

```log
2024-04-17T06:59:44.327Z ERROR 1 --- [nio-8090-exec-1] o.a.c.c.C.[.[.[/].[httpHandlerServlet]   : Servlet.service() for servlet [httpHandlerServlet] in context with path [] threw exception [Servlet execution threw an exception] with root cause

java.lang.IllegalStateException: Incompatible Tomcat implementation
        at org.springframework.util.Assert.state(Assert.java:76) ~[na:na]
        at org.springframework.http.server.reactive.TomcatHttpHandlerAdapter$TomcatServerHttpRequest.<clinit>(TomcatHttpHandlerAdapter.java:90) ~[na:na]
        at org.springframework.http.server.reactive.TomcatHttpHandlerAdapter.createRequest(TomcatHttpHandlerAdapter.java:67) ~[com.example.nativedemo.NativeDemoApplication:6.0.18]
        at org.springframework.http.server.reactive.ServletHttpHandlerAdapter.service(ServletHttpHandlerAdapter.java:172) ~[com.example.nativedemo.NativeDemoApplication:6.0.18]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:205) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149) ~[na:na]
        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149) ~[na:na]
        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[na:na]
        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[na:na]
        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:482) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[na:na]
        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[na:na]
        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[na:na]
        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:391) ~[na:na]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]

2024-04-17T06:59:44.328Z ERROR 1 --- [nio-8090-exec-1] o.a.coyote.http11.Http11NioProtocol      : Error reading request, ignored

java.lang.IllegalStateException: Calling [asyncPostProcess()] is not valid for a request with Async state [MUST_ERROR]
        at org.apache.coyote.AsyncStateMachine.asyncPostProcess(AsyncStateMachine.java:302) ~[na:na]
        at org.apache.coyote.AbstractProcessor.asyncPostProcess(AbstractProcessor.java:197) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:83) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]

2024-04-17T06:59:44.329Z  INFO 1 --- [nio-8090-exec-1] o.a.catalina.connector.CoyoteAdapter     : Encountered a non-recycled request and recycled it forcedly.

org.apache.catalina.connector.CoyoteAdapter$RecycleRequiredException: null
        at org.apache.catalina.connector.CoyoteAdapter.checkRecycled(CoyoteAdapter.java:522) ~[na:na]
        at org.apache.coyote.http11.Http11Processor.recycle(Http11Processor.java:1416) ~[na:na]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.release(AbstractProtocol.java:1085) ~[na:na]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:1060) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]

2024-04-17T06:59:45.426Z ERROR 1 --- [nio-8090-exec-2] o.a.c.c.C.[.[.[/].[httpHandlerServlet]   : Servlet.service() for servlet [httpHandlerServlet] in context with path [] threw exception [Servlet execution threw an exception] with root cause

java.lang.NoClassDefFoundError: Could not initialize class org.springframework.http.server.reactive.TomcatHttpHandlerAdapter$TomcatServerHttpRequest
        at org.springframework.http.server.reactive.TomcatHttpHandlerAdapter.createRequest(TomcatHttpHandlerAdapter.java:67) ~[com.example.nativedemo.NativeDemoApplication:6.0.18]
        at org.springframework.http.server.reactive.ServletHttpHandlerAdapter.service(ServletHttpHandlerAdapter.java:172) ~[com.example.nativedemo.NativeDemoApplication:6.0.18]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:205) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149) ~[na:na]
        at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:174) ~[na:na]
        at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:149) ~[na:na]
        at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[na:na]
        at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[na:na]
        at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:482) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[na:na]
        at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[na:na]
        at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[na:na]
        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:391) ~[na:na]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]

2024-04-17T06:59:45.428Z ERROR 1 --- [nio-8090-exec-2] o.a.coyote.http11.Http11NioProtocol      : Error reading request, ignored

java.lang.IllegalStateException: Calling [asyncPostProcess()] is not valid for a request with Async state [MUST_ERROR]
        at org.apache.coyote.AsyncStateMachine.asyncPostProcess(AsyncStateMachine.java:302) ~[na:na]
        at org.apache.coyote.AbstractProcessor.asyncPostProcess(AbstractProcessor.java:197) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:83) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:896) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]

2024-04-17T06:59:45.428Z  INFO 1 --- [nio-8090-exec-2] o.a.catalina.connector.CoyoteAdapter     : Encountered a non-recycled request and recycled it forcedly.

org.apache.catalina.connector.CoyoteAdapter$RecycleRequiredException: null
        at org.apache.catalina.connector.CoyoteAdapter.checkRecycled(CoyoteAdapter.java:522) ~[na:na]
        at org.apache.coyote.http11.Http11Processor.recycle(Http11Processor.java:1416) ~[na:na]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.release(AbstractProtocol.java:1085) ~[na:na]
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:1060) ~[na:na]
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1744) ~[na:na]
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[com.example.nativedemo.NativeDemoApplication:10.1.19]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) ~[na:na]
        at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[na:na]
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[na:na]
        at java.base@17.0.10/java.lang.Thread.run(Thread.java:840) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.nativedemo.NativeDemoApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]
```
