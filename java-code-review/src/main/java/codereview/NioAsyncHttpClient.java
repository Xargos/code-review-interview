package codereview;

import java.util.concurrent.CompletableFuture;

public interface NioAsyncHttpClient<RESOURCE> {

    <ID> CompletableFuture<RESOURCE> get(ID id);
    <REQUEST> CompletableFuture<RESOURCE> post(REQUEST payload);

}
