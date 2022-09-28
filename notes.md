
* Code to be reviewed.
* 
* Code goal: Send the request to create transaction to another service.
* 
* Code Smells covered:
* Long class
* Many parameters
* Class does more then it should
* Inconsistent styling
* POST? to check REST knowledge
* Not waiting for response? What if it failes?
* amount as double not BigDecimal?
* currency could be enum
* thread-safety? -> synchronize CompletableFuture
* public mutable parameter?
* no logging?