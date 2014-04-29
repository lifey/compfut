package com.performize.compfut.examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class CompletableFutureWithLambda {
    public void perform() {


        List<String> topSites = Arrays.asList(
                "www.google.com", "www.youtube.com", "www.yahoo.com", "www.msn.com"
        );

        List<CompletableFuture<Double>> relevanceFutures = topSites.stream().
                map(site -> CompletableFuture.supplyAsync(() -> downloadSite(site))).
                map(contentFuture -> contentFuture.thenApply(this::parse)).
                map(docFuture -> docFuture.thenCompose(this::calculateRelevance)).
                collect(Collectors.<CompletableFuture<Double>>toList());

        relevanceFutures.stream().reduce();

    }
    public static void main(String[] args) {
        CompletableFutureWithLambda  c = new CompletableFutureWithLambda();
          c.perform();
    }

    private  String downloadSite(String site) {
        return site;
    }
    private  String parse(String data) {
        return data;
    }
    private  CompletableFuture<Double> calculateRelevance(String site) {
        return supplyAsync(() -> 42.0);
    }
}
