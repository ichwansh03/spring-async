[Introduction to Spring Scheduling and monitoring the task with Spring Actuator ️🕛️📈️](https://ichwansholihin.medium.com/create-scheduled-and-monitoring-tasks-with-scheduling-and-spring-actuator-b61aa38417eb)

## Spring Async

* Untuk mengaktifkan fitur asynchronous pada spring, tambahkan anotasi `@EnableAsync` pada config class. Pada level method, tambahkan `@Async` untuk menandakan bahwa method tersebut harus dijalankan secara asynchronous.
* Jika ingin mengubah default thread-pool, [Docs](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.core.spring.task.execution.pool.allow-core-thread-timeout)
* Jika ingin mengaktifkan fitur schedule, tambahkan anotasi `@EnableScheduling` pada config class. Pada level method, tambahkan `@Scheduled` untuk menandakan bahwa method tersebut dijalankan secara periodik. [Scheduled Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/Scheduled.html)
* Scheduled akan otomatis dijalankan ketika spring running, berbeda dengan Async.
* Cron job digunakan untuk eksekusi scheduled, menggunakan ekspresi `* * * * * *` yg berarti ekspresi tersebut akan dieksekusi setiap detik. Gunakan template cron berikut [Crontab](https://crontab.guru/)

## Spring Reactive Webflux

* Spring webflux adalah aplikasi spring pada web yang reactive, berbeda dengan spring web mvc pada umumnya. Reactive disini artinya teknik programming yg menggunakan metode async dan non-blocking.
* Webflux dalam case example biasanya sering digunakan pada aplikasi web yg mengalami bottleneck pada proses I/O atau proses input-outputnya lambat. Ketimbang membuat thread untuk semua request, kita cukup gunakan thread yg ada di processor lalu satu thread itu dijalankan secara bergantian/non-blocking. kecuali jika terdapat proses non-I/O (CPU bound) tidak perlu gunakan webflux.
* Dokumentasi spring webflux [Docs](https://docs.spring.io/spring-framework/reference/web/webflux.html) 
* Jika menggunakan spring reactive, database juga harus menggunakan r2dbc.
* Spring reactive tidak support dengan automation db schema, jadi perlu menggunakan db migration tool seperti flyway db.
* Core dari spring reactive ada di publisher dan subscribernya, yakni penggunaan class Flux untuk collection resource dan class Mono untuk single resource

## Spring Monitoring

* Di Spring, terdapat fitur untuk monitoring endpoint, namanya Spring Actuator. Tambahkan dependenct spring boot starter actuator, lalu akses dengan `localhost:8080/actuator`.
* Heapdump digunakan untuk mengecek apakah terdapat memory leak pada sebuah object atau tidak. Gunakan aplikasi Visual VM untuk melihat hasil download dari file heapdump.
* Jika ingin memvisualisasikan actuator, gunakan [Micrometer](https://micrometer.io/) untuk melihat grafik metric

Reference:
[Getting Started with Spring Webflux](https://reflectoring.io/getting-started-with-spring-webflux/)
