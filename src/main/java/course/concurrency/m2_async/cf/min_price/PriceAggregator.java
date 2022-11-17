package course.concurrency.m2_async.cf.min_price;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class PriceAggregator {

    private PriceRetriever priceRetriever = new PriceRetriever();

    public void setPriceRetriever(PriceRetriever priceRetriever) {
        this.priceRetriever = priceRetriever;
    }

    private Collection<Long> shopIds = Set.of(10L, 45L, 66L, 345L, 234L, 333L, 67L, 123L, 768L);

    public void setShops(Collection<Long> shopIds) {
        this.shopIds = shopIds;
    }

    private final ExecutorService executor = Executors.newFixedThreadPool(24);

    public double getMinPrice(long itemId) {
        List<CompletableFuture<Double>> completableFutureList = shopIds.stream()
                .map(entry -> CompletableFuture
                .supplyAsync(() -> priceRetriever.getPrice(itemId, entry), executor)
                .completeOnTimeout(Double.NaN, 2960, TimeUnit.MILLISECONDS)
                .handle((result, exception) -> exception != null ? Double.NaN : result))
                .collect(Collectors.toList());

        CompletableFuture.allOf(completableFutureList.toArray(CompletableFuture[]::new)).join();

        return completableFutureList
                .stream()
                .mapToDouble(CompletableFuture::join)
                .filter(Double::isFinite)
                .min()
                .orElse(Double.NaN);
    }
}
