// MazeSearcher.java
// Andrew Davison, ad@fivedots.coe.psu.ac.th, Jan 2021
/* 
   Usage:
      java MazeSearcher maze1.txt    (maze2.txt)
*/


import java.io.*;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class MazeSearcher {
  private Coord Spath;
  public MazeSearcher(Maze maze) {
    ArrayList<Coord> path = new ArrayList<>();
    Coord entry = maze.getStart();
    if (explore(maze, entry.getX(), entry.getY(), path)) {
      maze.printPath(path);
    } else
      System.out.println("No path found");
  } // end of MazeSearcher()

  private boolean explore(Maze maze, int x, int y, ArrayList<Coord> path) {
    if (maze.isExit(x, y)) 
      return true;
    if (maze.isStart(x, y)) 
    {
      maze.setVisited(x, y);
      return explore(maze, x + 1, y, path);
    }
    if (maze.isWall(x, y))
      return false;
    if (maze.wasVisited(x, y))
      return false;
    if (maze.isValidLoc(x, y))
    {
          maze.setVisited(x, y);
          if (explore(maze, x, y + 1, path) || explore(maze, x + 1, y, path) || explore(maze, x, y - 1, path) 
              || explore(maze, x - 1, y, path)) { 
            Set_path(maze, x, y, path); 
            return true;
          } else
            return false;
    } 
    else
      return false;
  } // end of explore()

  private void Set_path(Maze maze, int x, int y, ArrayList<Coord> path) {// Function to set the path to the end
    Spath = new Coord(x, y);
    path.add(Spath);
  }
  // Students: you can add other functions if you wish

  // --------------------------------------------

  public static void main(String[] args) throws Exception {
    if (args.length != 1)
      System.out.println("Usage: java MazeSearcher <maze textfile>");
    else {
      Maze maze = new Maze(new File(args[0]));
      MazeSearcher dfs = new MazeSearcher(maze);
    }
  }

} // end of MazeSearcher class
