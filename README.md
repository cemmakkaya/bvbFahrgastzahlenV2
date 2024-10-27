# BVB Passenger Data Analysis Program (V2)

## Overview
This Java program analyzes passenger data from the Basel Public Transport System (BVB). Version 2.0 includes improved JSON parsing with Jackson, better error handling, and enhanced performance through optimized data structures.

## Authors
- Cem Akkaya
- Flower Dan Fluri

## Features
- Load and parse passenger data from JSON files using Jackson
- Analyze passenger numbers for different time periods:
  - Yearly analysis (YYYY)
  - Quarterly analysis (YYYY-QN)
  - Monthly analysis (YYYY-MM)
  - Weekly analysis (YYYY-WNN)
- Calculate key statistics:
  - Minimum passenger count
  - Maximum passenger count
  - Average passenger count
- Interactive command-line interface
- Robust error handling
- Support for both weekly and monthly data granularity

## System Requirements
- Java Runtime Environment (JRE) 8 or higher
- Jackson library (for JSON parsing)
- Sufficient memory to process large JSON files
- Read access to the input JSON file

## Dependencies
- `com.fasterxml.jackson.core:jackson-databind`
- `com.fasterxml.jackson.core:jackson-core`

## Project Structure
```
src/
├── Main.java              # Program entry point and user interface
├── DataAnalyzer.java      # Core analysis functionality
├── DataLoader.java        # JSON data loading using Jackson
├── PassengerData.java     # Data model with Jackson annotations
└── 100075.json           # Sample passenger data file
```

## Installation
1. Clone the repository or download the source files
2. Ensure you have Java and Maven/Gradle installed
3. Add Jackson dependencies to your project:
   ```xml
   <!-- Maven -->
   <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>2.13.0</version>
   </dependency>
   ```
   or
   ```gradle
   // Gradle
   implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.0'
   ```
4. Compile the Java files:
   ```bash
   javac -cp jackson-databind-2.13.0.jar:jackson-core-2.13.0.jar *.java
   ```

## Usage
1. Place your JSON data file in the `src` directory
2. Run the program:
   ```bash
   java -cp .:jackson-databind-2.13.0.jar:jackson-core-2.13.0.jar Main
   ```
3. Enter time periods in one of the following formats:
   - Year: `YYYY` (e.g., 2020)
   - Quarter: `YYYY-QN` (e.g., 2020-Q1)
   - Month: `YYYY-MM` (e.g., 2020-02)
   - Week: `YYYY-WNN` (e.g., 2020-W06)
4. Type 'exit' to quit the program

## Input Data Format
The program expects JSON data in the following format:
```json
[
  {
    "startdatum_kalenderwoche_monat": "YYYY-MM-DD",
    "fahrgaeste_einsteiger": number,
    "kalenderwoche": number,
    "granularitat": "string",
    "datum_der_monatswerte": "YYYY-MM"
  }
]
```

## Example Output
```
Analyseergebnis:
Zeitraum: 2020-Q1
Kleinste Fahrgastanzahl: 572000
Grösste Fahrgastanzahl: 2538000
Durchschnittliche Fahrgastanzahl: 1548750.00
```

## Key Improvements in Version 2.0
1. Jackson Integration
   - Replaced manual JSON parsing with Jackson library
   - Added proper JSON annotations
   - Improved error handling for JSON parsing

2. Code Optimization
   - Enhanced performance with optimized data structures
   - Improved memory usage
   - Better handling of null values

3. Error Handling
   - More robust error checking
   - Detailed error messages
   - Graceful handling of malformed data

## Data Specifications
- Date Range: 2020-02 to 2024-08
- Data Granularity: Weekly and Monthly
- Data Format: JSON
- Supported Time Periods: Year, Quarter, Month, Week
- Language: German (Data labels and output)

## Error Handling
The program includes comprehensive error handling for:
- Invalid JSON format
- Missing or corrupted data files
- Invalid date formats
- Invalid user input
- Out-of-range values
- Null or missing values in JSON data

## Known Limitations
- Data range is limited to 2020-02 through 2024-08
- Only supports German-formatted JSON input files
- Single file processing at a time
- Memory constraints based on available system RAM

## Contributing
To contribute to this project:
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License
This project is available under the MIT License. See the LICENSE file for more details.

## Support
For support and bug reports, please open an issue in the project's issue tracker.

## Version History
- 2.0: Added Jackson integration, improved error handling, optimized performance
- 1.0: Initial release with basic functionality
