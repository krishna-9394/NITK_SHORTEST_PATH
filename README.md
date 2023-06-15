# NITK Shortest Path

This is a Java program that calculates the shortest path between locations in NITK using Dijkstra's algorithm. It takes into account different modes of transportation and provides information about the path and distances.

## Prerequisites
- Java Development Kit (JDK) installed
- Input files: `nodesResponses.csv` and `edgesResponse.csv`

## Usage
1. Compile the Java program:
   ```bash
   javac Main.java
2. Follow the on-screen instructions to enter the current location, destination location, intermediate locations (optional), and mode of transportation.
3. Input Files
  - nodesResponses.csv: Contains information about the locations in NITK.
  - edgesResponse.csv: Contains information about the edges (paths) between locations.
## Program Flow
- Reads the location data from nodesResponses.csv and stores it in an array of nodes.
- Reads the edge data from edgesResponse.csv and builds the graph.
- Takes user input for the current location, destination location, intermediate locations (if applicable), and mode of transportation.
- Applies Dijkstra's algorithm to find the shortest path for each segment of the journey.
- Prints the total distance and destination information for each location visited.
## Example Output
Welcome to NITK! <br>
Enter your current location: Nescafe <br>
Enter your destination location: LHC A <br>
Enter 1 if you want to enter intermediate locations else enter 0: 1 <br>
Enter the no of intermediate locations you want to visit for e.g. [Nescafe,Chaitanya,LHC A]: 2 <br>
Enter the intermediate locations: <br>
Chaitanya <br>
LHC B <br>
Enter the mode of transportation <br>
0 for WALKING <br>
1 for BICYCLES <br>
2 for MOTORCARS: <br>
1 <br>
<br>
Nescafe Chaitanya BICYCLES <br>
Chaitanya LHC A BICYCLES <br>
<br>
Total distance: 250 <br>
<br>
Destination information: <br>
Location: Chaitanya <br>
Working Hours: 9 AM - 5 PM <br>
Purpose: Academic Block <br>
Are visitors allowed: Yes <br>
Contact Details: <br>
<br>
Contact Number: 1234567890 <br>
Email Address: chaitanya@nitk.edu <br>
Website: www.chaitanya.nitk <br>
Location: LHC A <br>
Working Hours: 8 AM - 6 PM <br>
Purpose: Lecture Hall Complex <br>
Are visitors allowed: Yes <br>
Contact Details: <br>
<br>
Contact Number: 9876543210 <br>
Email Address: lhca@nitk.edu <br>
Website: www.lhca.nitk <br>

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License.
