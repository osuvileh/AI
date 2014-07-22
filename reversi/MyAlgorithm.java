import reversi.*;
import java.util.Vector;
import java.util.Iterator;

public class MyAlgorithm implements ReversiAlgorithm
{
    // Constants
    private final static int DEPTH_LIMIT = 2; // Just an example value.
    // Variables
    boolean initialized;
    volatile boolean running; // Note: volatile for synchronization issues.
    GameController controller;
    GameState initialState;
    int myIndex;
	int AiIndex;
    Move selectedMove;
	Node parento;

    public MyAlgorithm() {} //the constructor
      
    public void requestMove(GameController requester)
    {
        running = false;
        requester.doMove(selectedMove);
    }

    public void init(GameController game, GameState state, int playerIndex, int turnLength)
    {
        initialState = state;
        myIndex = playerIndex;
        controller = game;
        initialized = true;
	}

    public String getName() { return "MyAlgorithm"; }

    public void cleanup() {}
    public void run()
    {
        //implementation of the actual algorithm
        while(!initialized);
        initialized = false;
        running = true;
        selectedMove = null;

        int currentDepth = 1;

        while (running && currentDepth < DEPTH_LIMIT)
        {
			Move newMove = searchToDepth(currentDepth++);
  
            // Check that there's a new move available.
            if (newMove != null)
                selectedMove = newMove;
        }
      
        if (running) // Make a move if there is still time left.
        {
            controller.doMove(selectedMove);
        }
    }
     
    Move searchToDepth(int depth)
    {
        // - Create the tree of depth d (breadth first, depth first, beam search, alpha beta pruning, ...)
        // - Evaluate the leaf nodes
        // - If you think normal minimax search is enough, call the propagateScore method of the parent node
        //   of each leaf node
        // - Call the getOptimalChild method of the root node
        // - Return the move in the optimal child of the root node
        // - Don't forget the time constraint! -> Stop the algorithm when variable "running" becomes "false"
        //   or when you have reached the maximum search depth.

		
		if (myIndex == 1)
			AiIndex = 0;
		else
			AiIndex = 1;
        Move optimalMove;
        Vector moves = initialState.getPossibleMoves(myIndex);

        if (moves.size() > 0)
            optimalMove = (Move)moves.elementAt(0); // Any movement that just happens to be first.
        else
            optimalMove = null;
		
		//Node child = new Node();
		//Node juuri = new Node();
		//child.setScore(12);
		//juuri.setState(initialState);
		//juuri.setMove(optimalMove);
		//juuri.setScore(100);
		//juuri.addChild(child);
		//juuri.print();
		int alpha = -100000;
        int beta = 100000;
        for (Move move : moves):
		    Node temp = new Node(initialState.getNewInstance(move), move);
            if (myIndex == 1):
                temp.setScore(java.lang.Math.min(alpha, alpha)
            //tmp.setScore( MinPlayer( tmp, alpha, beta, depth - 1, transposition_table ) );
		
		//System.out.println("SELECTED: " + optimalMove);
		//System.out.println("SECOND STATE");
		//GameState nextState = initialState.getNewInstance(optimalMove);
		//moves = nextState.getPossibleMoves(AiIndex);

		//e = moves.iterator();
		//while (e.hasNext()) {         
		//	System.out.println("Element = " + e.next());
		//}

        return optimalMove;
    }
    double alphabeta(Node node, int depth, double alpha, double beta, int player){
        if (depth = 0)
            //return evaluated game state
        if myIndex
            for (Move move : moves):
                Node temp = new Node(initialState.getNewInstance(move), move);
                temp.setScore(java.lang.Math.max(alpha, alphabeta(temp.getOptimalChild)))

    }
    double maximizePlayer(Node node, int depth, double alpha, double beta, int player){
        expandedNodes++;
        if (depth == 0)
            //return evaluated state
        Vector<Move> moves = node.getState().getPossibleMoves(player);
        if(moves.size() == 0)
            //skip turn if no possible moves

        for (Move move : moves){
            double points = minimizePlayer(new Node(node.getState().getNewInstance(move), move), alpha, beta, depth - 1);
            alpha = Math.max(alpha, points)
            if (points >= beta)
                break;
        }
        return points;





    }

    double minimizePlayer(Node node, int depth, double alpha, double beta, int player){
        spawned++;



    }

    double evaluate(Node node, int player){
        int score;
        //checks which player's move it is
        GameState state = node.getState();
        Move move = node.getMove();
        int x = move.getX();
        int y = move.getY();
        int maximize = state.getMarkCount(player);
        if (player == 1)
            int minimize = state.getMarkCount(0);
        else:
            int minimize = state.getMarkCount(1);


        int [][] scores = {
            {100, -20, 10,  5,  5, 10, -20, 100}
            {-20. -50. -2, -2, -2, -2, -50, -20}
            {10,   -2, -1, -1, -1, -1,  -2,  10}
            {5,    -2, -1, -1, -1, -1,  -2,   5}
            {5,    -2, -1, -1, -1, -1,  -2,   5}
            {10,   -2, -1, -1, -1, -1,  -2,  10}
            {-20. -50. -2, -2, -2, -2, -50, -20}
            {100, -20, 10,  5,  5, 10, -20, 100}
        }

        //positional player's endgame evaluation
        score = maximize-minimize;

        if (state == player)
            score += scores[x][y];
        else:
            score -= scores[x][y];
        
        return score;
        

    }   
}
 