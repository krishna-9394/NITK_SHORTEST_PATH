import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to NITK!");
        Node[] nodes = locationInput();
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].print();
        }
//        dataInput();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your current location: ");
        String curr = sc.nextLine();
        System.out.print("Enter your destination location: ");
        String dest = sc.nextLine();
        System.out.println("for eg. [Nescafe,Chaitanya,LHC A]");
        System.out.print("Enter the no of intermediate locations you want to visit: ");
        int n = sc.nextInt();
        System.out.println("Enter the intermediate locations: ");
        String[] intermediateLocations = new String[n+2];
        intermediateLocations[0] = curr;
        intermediateLocations[n+1] = dest;
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            intermediateLocations[i] = sc.nextLine();
        }
        n+=2;
        // applying dijkstra's algo for all the destination;
//        for(int i = 1;i<n;i++){
//            System.out.println(intermediateLocations[i-1]+"  "+intermediateLocations[i]);
//            Graph.shortest_path(intermediateLocations[i-1],intermediateLocations[i]);
//        }
    }
    public static Node[] locationInput() throws FileNotFoundException {
        String data = "", locationName = "", workingHour = "", purpose= "", contactDetails = "";
        boolean isVisitorsAllowed = true;
        System.out.println("This are some of the locations in NITK");
        File myObj = new File("C:\\Users\\Krishna Kumar\\IdeaProjects\\NITK_SHORTEST_PATH\\src\\locations.txt");
        Scanner myReader = new Scanner(myObj);
        if(myReader.hasNextLine()) data = myReader.nextLine();
        int n = Integer.parseInt(data);
        Node[] nodes = new Node[n];
        int i = 0;
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if(myReader.hasNextLine()) workingHour = myReader.nextLine();
            if(myReader.hasNextLine()) purpose = myReader.nextLine();
            if(myReader.hasNextLine()) isVisitorsAllowed = Boolean.parseBoolean(myReader.nextLine());
            if(myReader.hasNextLine()) contactDetails = myReader.nextLine();
            nodes[i] = new Node(Integer.parseInt(data.substring(0,2)),data.substring(3),workingHour,purpose,isVisitorsAllowed,contactDetails);
            i++;
        }
        myReader.close();
        return nodes;
    }
    public static void dataInput() throws FileNotFoundException {
        System.out.println("Feeding the data into the system");
        File myObj = new File("C:\\Users\\Krishna Kumar\\IdeaProjects\\NITK_SHORTEST_PATH\\src\\locations.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }
}
