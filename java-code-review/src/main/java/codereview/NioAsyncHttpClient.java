package codereview;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface NioAsyncHttpClient<RESOURCE> {

    <ID> CompletableFuture<RESOURCE> get(ID id);
    <REQUEST> void post(Message<REQUEST> payload, BiConsumer<RESOURCE, Exception> consumer);

}
