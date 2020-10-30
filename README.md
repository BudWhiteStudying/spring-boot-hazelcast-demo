#### Spring Boot + Hazelcast demo
This simple POC demonstrates the integration between Spring Boot and Hazelcast for a distributed caching solution. It spawns a Spring Boot Application exposing two APIs:
- `GET` `/resource` - retrieves a 'Hello' message from the `waitThenSayHello()` service method
- `DELETE` `/cache` - invalidates the cache potentially storing the result of the `GET` `/resource` API

##### Single instance
If started on a single instance, the implementation is just a plain cache implementation:
1. invoke the `GET` `/resource` API, notice how it takes ~2 seconds in order to respond (see [MyService.java](src/main/java/com/budwhite/studying/hazelcast/demo/service/MyService.java));
2. invoke the `GET` `/resource` API again, notice how it responds instantly (the result is cached);
3. invoke the `DELETE` `/cache` API and then invoke the `GET` `/resource` API again, it will again take ~2 seconds in order to respond, since the cache has been evicted.

##### Multiple instances
You can start multiple instances of the application e.g. by opening multiple workspaces, be sure to set a different `server.port` property in the `application.properties` file for each instance. Let's assume you started the application on two instances, one on port ´8080´ and one on port `8081`.
1. invoke the `GET` `/resource` API on port `8080`, it will obviously still take ~2 seconds in order to respond;
1. invoke the `GET` `/resource` API on port `8081`, notice how it responds instantly (the result is cached and the cache is distributed on both instances);
3. invoke the `DELETE` `/cache` API on port `8081` and then invoke the `GET` `/resource` API on port `8080` again, it will again take ~2 seconds in order to respond (the cache has been evicted on one instance, but since it's distributed the eviction affected all instances).
