import java.util.Scanner;
import java.util.StringTokenizer;

class BredthFirstSearch {
	boolean[] visited;
	Queue<Integer> vertexQueue;
	int[][] array;
	int size;

	BredthFirstSearch(int size) {
		this.size = size;
		array = new int[size][size];
		visited = new boolean[size];
		vertexQueue = new Queue<Integer>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = 0;
			}
		}
	}

	public void setAdjacencyMatrix(int[][] array) {
		this.array = array;
	}

	public void createAdjacensyMatrix(int vertex1, int vertex2) {
		array[vertex1][vertex2] = 1;
	}

	public void print() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println("\n");
		}
	}
	public void getBredthFirstSearch(int vertex, int option) {
		vertexQueue.enQueue(vertex);
		visited[vertex] = true;
		int i;
		int searchVertex;
		while (!vertexQueue.isEmpty()) {
            searchVertex = vertexQueue.deQueue();
            i = 0;
            if (option == 1) {
            	System.out.print((searchVertex + 1) + " ");
            } else {
            	System.out.print(searchVertex);
            }
            while (i < size) {
                if (array[searchVertex][i] == 1 && visited[i] == false) {
                    vertexQueue.enQueue(i);
                    visited[i] = true;
                }
                i++;
            }
        }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nov = sc.nextLine();
		int noOfVertices = Integer.parseInt(nov);
		String o = sc.nextLine();
		int option = Integer.parseInt(o);
		if (option == 0) {
			BredthFirstSearch bfs =  new BredthFirstSearch(noOfVertices + 1);
			int i = 0;
			while (i < noOfVertices) {
				int count = 0;
				String list = sc.nextLine();
				StringTokenizer st = new StringTokenizer(list, "->");
				int vertex1 = 0;
				while (st.hasMoreTokens()) {
					if (count == 0) {
						vertex1 = Integer.parseInt(st.nextToken());
					}
					int vertex2 = Integer.parseInt(st.nextToken());			
					bfs.createAdjacensyMatrix(vertex1, vertex2);
					count++;
				}
				i++;
			}
			bfs.getBredthFirstSearch(1, 0);
		}
		if (option == 1) {
			int size = noOfVertices;
			BredthFirstSearch bfs =  new BredthFirstSearch(size);
			int array[][] = new int[size][size];
			int i = 0, j = 0;
			while (i < size) {
				String s = sc.nextLine();
				StringTokenizer st = new StringTokenizer(s, " ");
				j = 0;
				while (st.hasMoreTokens()) {
					int value = Integer.parseInt(st.nextToken());
					array[i][j] = value;
					j++;
				}
				i++;
			}
			bfs.setAdjacencyMatrix(array);
			bfs.getBredthFirstSearch(0, 1);
		}
	}
}