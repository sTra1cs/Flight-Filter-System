# Flight Filter System

## Project Description

This Java project is a flight filter system that processes air travel from one point to another with possible intermediate stops. A flight is represented as a collection of one or more elementary movements called segments. Each segment is an atomic transportation characterized simply by a departure and an arrival datetime.

The project includes a module that filters a set of flights according to various dynamically chosen rules based on the execution context. The filtering rules include, but are not limited to, excluding flights that:
- Depart before the current moment in time.
- Contain segments where the arrival datetime is earlier than the departure datetime.
- Have a total ground time exceeding two hours between consecutive segments.

## Implementation

The core functionality is encapsulated within the `com.flightFilter.core` package. The main classes and interfaces needed to set up the flight filtering module are part of this package. The project follows SOLID principles and demonstrates effective use of object-oriented design patterns.

No external libraries are required for the running of this project, and the user interface is not considered—output is directed to the console.

## Setup

1. Clone this repository.
2. Open the project in an IDE like IntelliJ IDEA.
3. Ensure Java is installed on your system and configured in your IDE.

## Running the Project

To run the project, navigate to the `Main` class located in the `com.flightFilter.core` package and execute it. This class outputs the results of filtering a test set of flights to the console. The test set is generated using the `FlightBuilder.createFlights()` method.

## Testing

The project includes a set of JUnit tests covering the filtering logic to ensure that all scenarios are correctly handled according to the specified rules. Run the tests through your IDE to verify the implementation.

## Contributing

Feel free to fork this repository and submit pull requests to enhance the functionalities or improve the existing module. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is available under the MIT license. See the LICENSE file for more info.