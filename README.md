# Solution:
    1, Used it.remove()  [iterator remove] instead of creating a concurrent sync list that allows the developer to do modification and iteratoration at the same time.
    2, Delete AtomicInteger numberOfExecutingCase. Used ExecutorService to delegate it.
    3, Added threadPool.shutdown(); [ExecutorService shutdown] to end multi-threading.
