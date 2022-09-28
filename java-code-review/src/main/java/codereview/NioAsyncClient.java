package codereview;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface NioAsyncClient<RESOURCE> {

    <ID> CompletableFuture<RESOURCE> get(ID id);
    <REQUEST> void send(Message<REQUEST> payload, BiConsumer<RESOURCE, Exception> consumer);

}
