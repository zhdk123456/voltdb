# Voter Application

This example application simulates a phone based election process. Voters (based on phone numbers generated randomly by the client application) are allowed a limited number of votes.

Many attributes of the application are customizable through arguments passed to the client, including:

- The number of contestants (between 1 and 12)
- How many votes are allowed per telephone number
- How long the sample client runs
- The maximum number of transactions the client will attempt per second
- When to start recording performance statistics
- How frequently to report those statistics

These attributes can be adjusted by modifying the arguments to the "client" target in run.sh.

Measuring Performance
---------------------
The main goal of the voter application is to demonstrate the performance possibilities of VoltDB while still maintaining fully ACID transactions:

- Stored procedures are invoked asynchronously.
- The client application supports rate control (the number of transactions per second to send to the servers), which can be modified in the run.sh file.
- The client also records and reports thoughput and latency.

As delivered, the example runs both client and server on a single node (like the other examples). However, it can easily be reconfigured to run any combination of clients and servers.

- The servers support multiple clients at one time
- Single node or multi-node clusters are supported

To test the example on a different configuration, simply edit run.sh, listing one server node as the lead node when building the catalog and using a comma-separated list of the server addresses as an argument to the client. See the comments in the build script for details.

Interpreting the Results
------------------------
The default client configuration will allow the system to automatically tune itself for optimal throughput, regardless of your underlying hardware and cluster deployment.

The latency numbers reported by the default benchmark settings may be higher than is typical, as the cluster is near peak load. Rate-limiting your clients using the "--ratelimit=X" argument to a number that is less than the maximum throughput for your hardware should show lower and/or more consistent latency numbers. This can be done easily by editing the run.sh script.

The "Voter" application is specifically designed for benchmarking to give you a good feel for the type of performance VoltDB is capable of on your hardware.

For more on benchmarking and tips on application tuning, make sure you visit the VoltDB blog:
 - http://voltdb.com/search/node/benchmark
 - http://voltdb.com/search/node/tuning


Quickstart
---------------------------
VoltDB Examples come with a run.sh script that sets up some environment and saves some of the typing needed to work with Java clients. It should be fairly readable to show what is precisely being run to accomplish a given task.

1. Make sure "bin" inside the VoltDB kit is in your path.
2. Type "voltdb create -f" to start an empty, single-node VoltDB server.
3. Open a new shell in the same directory and type "sqlcmd < ddl.sql" to load the schema and the jarfile of procedures into VoltDB.
4. Type "./run.sh client" to run the client code.

You can stop the server or running client at any time with `ctrl-c` or `SIGINT`.

Note that the downloaded VoltDB kits include pre-compiled stored procedures and client code as jarfiles. To run the example from a source build, it may be necessary to compile the Java source code by typing "run.sh jars" before step 3 above. Note that this step requires a full Java JDK.

Other run.sh Actions
-----------
- *run.sh* : start the server
- *run.sh server* : start the server
- *run.sh init* : compile stored procedures and load the schema and stored procedures
- *run.sh jars* : compile all Java clients and stored procedures into two Java jarfiles
- *run.sh client* : start the client, more than 1 client is permitted
- *run.sh sync-benchmark* : start the synchronous client, more than 1 client is permitted
- *run.sh jdbc-benchmark* : start the JDBC client, more than 1 client is permitted
- *run.sh clean* : remove compilation and runtime artifacts
- *run.sh cleanall* : remove compilation and runtime artifacts *and* the two included jarfiles

If you change the client or procedure Java code, you must recompile the jars by deleting them in the shell or using `./run.sh jars`.

Client Behavior Options
---------------------------
You can control various characteristics of the demo by modifying the parameters passed into the java application in the "client" function of the run.sh script.

**Speed & Duration:**

    --displayinterval=5           (seconds between status reports)
    --warmup=5                    (how long to warm up before measuring
                                   benchmark performance.)
    --duration=120                (benchmark duration in seconds)
    --ratelimit=20000             (run up to this rate of requests/second)

**Cluster Info:**

    --servers=$SERVERS            (host(s) client connect to, e.g.
                                   =localhost
                                   =localhost:21212
                                   =volt9a,volt9b,volt9c
                                   =foo.example.com:21212,bar.example.com:21212)

**Parameters Affecting Simulation:**

    --contestants=6               (number of contestants to vote on)
    --maxvotes=2                  (max votes per phone number)
    --threads=100                 (number of parallel client threads [only in sync or jdbc])

Customizing this Example
---------------------------
See the "deployment-examples" directory within the "examples" directory for ways to alter the default single-node, no authorization deployment style of the examples. There are readme files and example deployment XML files for different clustering, authorization, export, logging and persistence settings.

