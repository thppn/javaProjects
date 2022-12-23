# csvStatisticsReporter
Project for the lesson of Software Development 2019
## Purpose
Java application for analyzing [Kaggle](https://www.kaggle.com/uciml/electric-power-consumption-data-set) household electric power consumption dataset.
## UML

### package _dataload;_
The package responsible for reading the measurement data from the input files and
loading them in the appropriate collection(s) in memory. The main functionality of this
subsystem is summarized by the interface ILoader.
*br*
![dataload.png](uml%2Fdataload.png)
*br*
*br*
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
