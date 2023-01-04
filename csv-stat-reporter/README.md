# csvStatisticsReporter
Project for the lesson of Software Development 2019
## Description
This application reads CSV files from the Kaggle dataset on household power consumption and aggregates the consumption data for the kitchen, laundry room, and electric water heater. The available aggregate functions are sum and average, but the architecture of the application allows for easy expansion to add more functions.

The application also creates reports in HTML, Markdown, and TXT format, and it is easy to add more report types. JUnit tests and UML diagrams are provided to aid in the development and maintenance of the application.

## Requirements
* Java 8 or higher

## UML
### package _dataload;_
The package responsible for reading the measurement data from the input files and
loading them in the appropriate collection(s) in memory. The main functionality of this
subsystem is summarized by the interface ILoader.


![dataload.png](uml%2Fdataload.png)

### package _datamodel;_
The package keeping the domain classes of the system. Notable modules are the IResult
interface, that prescribes the functionality of the aggregation result, and, the
MeasurementRecord class that is the representative of each measurement = line in the
input files.


![datamodel.png](uml%2Fdatamodel.png)

### package _reporting;_
The package responsible for creating output reports with the statistics for the data sets.
Reports come in different formats, e.g., text, html, markdown (md). The main
functionality of this subsystem is summarized by the interface IResultReporter.


![reporting.png](uml%2Freporting.png)
### package _timeaggregation;_
The package responsible for grouping the loaded measurements into groups, one
per time period, and for extracting the respective statistics. The main functionality of this
subsystem is summarized by the interface IAggregator.


![timeaggregation.png](uml%2Ftimeaggregation.png)

### package _mainengine;_
The main package includes the IMainEngine interface that exports the fundamental
functionality of the back-end, and its implementation.


![mainengine.png](uml%2Fmainengine.png)
