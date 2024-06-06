# Misra-Gries
The Misra-Gries algorithm is a streaming algorithm used for frequency estimation, particularly in finding the most frequent items (or elements) in a large dataset with limited memory. It is designed to process data streams where it is impractical to store all items due to memory constraints.


The Misra-Gries algorithm is a powerful tool for frequency estimation in streaming data, balancing accuracy and memory efficiency. It is widely used in scenarios where data comes in continuously, and only approximate counts of frequent items are required.

## Exemplary applications
- Network Traffic Monitoring: Identifying the most frequent IP addresses accessing a server.
- Market Basket Analysis: Finding the most common items in transaction logs.
- Sensor Data Analysis: Determining the most frequent sensor readings in IoT applications.

## Usage
To start the program one must, make sure to install scala compiler and type the following commands in a terminal:
```
scalac Misra-Gries.scala
scala Misra-Gries <text filename> 
```
