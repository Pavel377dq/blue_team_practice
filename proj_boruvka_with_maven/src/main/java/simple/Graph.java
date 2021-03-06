package simple;

import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

public class Graph implements ILoadable, IChangable{

	//private static final String File = null;
	private int vertNum;
    private int edgeNum;
    private Edge[] edges;
    private String[] vertices;
    boolean isolated;
    
    public Graph(){
    	this.vertNum = 0;
        this.edgeNum = 0;
        this.vertices = new String[100];
        this.edges = new Edge[100];
    };
    
    
    
    public void generateGraph(int vertNum, int edgeNum){
    	
        this.vertNum = vertNum;
        this.edgeNum = edgeNum;
        this.vertices = new String[vertNum];
        this.edges = new Edge[edgeNum];
        
        //File f = new File("generating.txt");
        //f.createNewFile();
        //FileWriter writer = new FileWriter(f);
        System.out.println("sdfsffs");
        for(int i = 0; i < this.vertNum; i++){
        	
        	int c = i + 65;
        	char a = (char)c;
        	String str1 = Integer.toString(i);
        	String str2 = String.valueOf(a);
        	String str = str1 + " " + str2;
        	String[] aux = str.split(" ");
            vertices[Integer.parseInt(aux[0])] = aux[1];
            System.out.println("sdfsffs");
        }
        for(int i = 0; i < this.edgeNum; i++){
        	
        	SecureRandom rand = new SecureRandom();

        	//String[] edgeValues = line.split(" ");
        	int src =  rand.nextInt(vertNum);
        	System.out.println(src);
        	int dest =  rand.nextInt(vertNum);
        	System.out.println(dest);
        	while(src==dest) dest =  rand.nextInt(vertNum);
        	int weight = rand.nextInt(21);
        		
            edges[i] = new Edge(src, dest, weight);
            System.out.println("sdfsffs");
       
        }
        checkIsolatedVert();
    
    }
    public void checkIsolatedVert() {
    	
    	int k = 0;
    	int check = 0;
    	for(int i = 0; i < this.vertNum; i++) {
    		for(int j = 0; j < this.edgeNum; j++) {
    			if((i == edges[j].getSrc())||(i == edges[j].getDest())) check++;
    		}if(check > 0) {k++;check = 0;}
    	}
    	if(k != vertNum) isolated = true;
    	else isolated = false;
    	
    }
    
    
    ;
    @Override
    public void readFromFile(){
        try {
        	
        	String path = "test.txt";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            String[] entryValues = line.split(" ");
            this.vertNum = Integer.parseInt(entryValues[0]);
            this.edgeNum = Integer.parseInt(entryValues[1]);
            this.vertices = new String[100];
            this.edges = new Edge[100];
            int iteration = 0;

            for(int i = 0; i < this.vertNum; i++){
                line = br.readLine();
                String[] aux = line.split(" ");
                vertices[Integer.parseInt(aux[0])] = aux[1];
            }

            while((line = br.readLine()) != null){
                String[] edgeValues = line.split(" ");
                edges[iteration] = new Edge(Integer.parseInt(edgeValues[0]), Integer.parseInt(edgeValues[1]), Integer.parseInt(edgeValues[2]));
                //edges[iteration].setSrc(Integer.parseInt(edgeValues[0]));
                //edges[iteration].setDest(Integer.parseInt(edgeValues[1]));
                //edges[iteration].setWeight(Integer.parseInt(edgeValues[2]));
                iteration++;
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        } checkIsolatedVert();
    }

    public void clear() {
    	this.vertNum = 0;
        this.edgeNum = 0;
        this.vertices = new String[100];
        this.edges = new Edge[100];
    	
    }
    
    public void addNode(String a, int x, int y) {
    	
    	vertices[vertNum] = a;
    	this.vertNum++;
    	System.out.println(vertNum);
   
    }
    public void addEdge(int x, int y, int z) {
    	edges[edgeNum] = new Edge(x, y, z);
    	this.edgeNum++;
    	checkIsolatedVert();
    }

	@Override
	public void generateGraph() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddVertice() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CommonVertices() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Boruvka() {
		
		
	}

	@Override
	public void DeleteVertice() {
		// TODO Auto-generated method stub
		
	}
	
	 	public String[] getVertNames(){
	        return this.vertices;
	    }

	    public Edge[] getEdges() {
	        return edges;
	    }

	    public int getVertNum() {
	        return vertNum;
	    }

	    public int getEdgeNum() {
	        return edgeNum;
	    }



		@Override
		public void changeGraph() {
			// TODO Auto-generated method stub
			
		}


}
