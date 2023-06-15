import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Graph graph = new Graph(34);
    static ArrayList<Edges> edgesList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to NITK!");
        Node[] nodes = locationInput();
        dataInput();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your current location: ");
        String curr = sc.nextLine();
        System.out.print("Enter your destination location: ");
        String dest = sc.nextLine();
        int ch, n;
        System.out.print("Enter 1 if you want to enter intermediate locations else enter 0: ");
        ch = sc.nextInt();
        if(ch==1) {
            System.out.print("Enter the no of intermediate locations you want to visit ");
            System.out.print("for eg. [Nescafe,Chaitanya,LHC A]: ");
            n = sc.nextInt();
            System.out.print("Enter the intermediate locations: ");
        } else {
            n = 0;
        }
        String[] intermediateLocations = new String[n + 2];
        intermediateLocations[0] = curr;
        intermediateLocations[n+1] = dest;
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            intermediateLocations[i] = sc.nextLine();
        }
        n+=2;
        System.out.print("Enter the mode of transportation \n0 for WALKING\n1 for BICYCLES\n2 for MOTORCARS: \n");
        int m = sc.nextInt();
        Vehicle mode;
        if(m==0) mode = Vehicle.WALKING;
        else if(m==1) mode = Vehicle.BICYCLES;
        else mode = Vehicle.MOTORCARS;
//         applying dijkstra's algo for all the destination;
        int totalDist = 0;
        for(int i = 1;i<n;i++){
            System.out.println(intermediateLocations[i-1]+"  "+intermediateLocations[i]+"  "+mode);
            int temp = graph.dijkstrasAlgo(mode,Integer.parseInt(intermediateLocations[i-1]), Integer.parseInt(intermediateLocations[i]), 34);
            totalDist += temp;
        }
        System.out.println("\nTotal distance: " + totalDist);
        System.out.println("\nDestination information: ");
        for(int i=1; i<n; i++){
            infoPrint(Integer.parseInt(intermediateLocations[i]));
        }
    }
    public static Node[] locationInput() throws FileNotFoundException {
        String csvFile = "/workspaces/NITK_SHORTEST_PATH/src/nodesResponses.csv";
        String line;
        String csvSplitBy = ",";
        int n ;
        Node[] nodes = new Node[0];

        ArrayList<Edges> nodesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row
            n = Integer.parseInt(br.readLine());
            br.readLine();
            nodes = new Node[n];
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String locationName = "", workingHour = "", purpose= "", contactDetails = "",isVisitorsAllowed;
                int id;
                id = Integer.parseInt(data[0].substring(0,2));
                locationName = data[0].substring(3);
                workingHour = data[1];
                purpose = data[2];
                isVisitorsAllowed = data[3];
                contactDetails = "Contact Number: "+data[4]+"\nEmail Address: "+data[5]+"\nWebsite: "+data[6];
                nodes[i] = new Node(id,locationName,workingHour,purpose,isVisitorsAllowed,contactDetails);
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("This are some of the locations in NITK");
        for (Node node: nodes) {
            System.out.println(node.toString());
        }
        return nodes;
    }
    public static void infoPrint(int loc) {
        String csvFile = "/workspaces/NITK_SHORTEST_PATH/src/nodesResponses.csv";
        String line;
        String csvSplitBy = ",";
        int n ;
        Node[] nodes = new Node[0];

        ArrayList<Edges> nodesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row
            n = Integer.parseInt(br.readLine());
            br.readLine();
            nodes = new Node[n];
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String locationName = "", workingHour = "", purpose= "", contactDetails = "",isVisitorsAllowed;
                int id;
                id = Integer.parseInt(data[0].substring(0,2));
                locationName = data[0].substring(3);
                workingHour = data[1];
                purpose = data[2];
                isVisitorsAllowed = data[3];
                contactDetails = "Contact Number: "+data[4]+"\nEmail Address: "+data[5]+"\nWebsite: "+data[6];
                nodes[i] = new Node(id,locationName,workingHour,purpose,isVisitorsAllowed,contactDetails);
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        String in = nodes[loc-1].info();
        System.out.println("\n"+in);
    }
    public static void dataInput() throws FileNotFoundException {
        String csvFile = "/workspaces/NITK_SHORTEST_PATH/src/edgesResponse.csv";
        String line;
        String csvSplitBy = ",";



        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                int distance = Integer.parseInt(data[0]);
                String[] allowedVehiclesArray = data[1].split(" ");
                String instructions = data[2];
                int sourceNode = Integer.parseInt(""+data[3].charAt(0)+data[3].charAt(1));
                int destinationNode = Integer.parseInt(""+data[4].charAt(0)+data[4].charAt(1));
                String landmarks;
                Edges leftEdge = new Edges(distance,sourceNode,destinationNode,allowedVehiclesArray,instructions);
                Edges rightEdge = new Edges(distance,destinationNode,sourceNode,allowedVehiclesArray,instructions);
                if (data.length >= 5) {
                    landmarks = data[4];
                    leftEdge.setLandmarks(landmarks);
                    rightEdge.setLandmarks(landmarks);
                }
                graph.insertEdge(leftEdge);
                graph.insertEdge(rightEdge);
                edgesList.add(leftEdge);
                edgesList.add(rightEdge);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
