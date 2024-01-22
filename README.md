## Spring Async

* Untuk mengaktifkan fitur asynchronous pada spring, tambahkan anotasi `@EnableAsync` pada config class. Pada level method, tambahkan `@Async` untuk menandakan bahwa method tersebut harus dijalankan secara asynchronous.
* Jika ingin mengubah default thread-pool, [Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.core.spring.task.execution.pool.allow-core-thread-timeout)
* Jika ingin mengaktifkan fitur schedule, tambahkan anotasi `@EnableScheduling` pada config class. Pada level method, tambahkan `@Scheduled` untuk menandakan bahwa method tersebut dijalankan secara periodik. [Scheduled Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html)
* Scheduled akan otomatis dijalankan ketika spring running, berbeda dengan Async.