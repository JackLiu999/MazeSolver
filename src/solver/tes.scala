package solver

import bfs.Graph
import maze.GridLocation
import maze._
import solver.PathFinding

object tes {
  def main(arg: Array[String]): Unit ={
    var map: List[List[MapTile]] = List(
      MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"),
      MapTile.generateRow("O----------------------------O"),
      MapTile.generateRow("O-O-OOOO-OOO-O-O-O-OOOOOOOOO-O"),
      MapTile.generateRow("O-O----------O---O-O---------O"),
      MapTile.generateRow("O-OOOOOOOOOOOOOO-O-OOOOOOOOOOO"),
      MapTile.generateRow("O-O-O----------OOO--O---OO---O"),
      MapTile.generateRow("O-O---OO-OOOOOOO-OO-O-O-OO-O-O"),
      MapTile.generateRow("O-OOOOO--O-----O--O---O-OO-O-O"),
      MapTile.generateRow("O-------OO-OOO-OO-OOOOO----O-O"),
      MapTile.generateRow("OOO-OOOOO--O-O-OO-OO-OOOOOOO-O"),
      MapTile.generateRow("O--------------------------OGO"),
      MapTile.generateRow("OO-OOOOOOOOOOOOOOOOOOOOOOOOO-O"),
      MapTile.generateRow("O--OO---O---O---O---O---O--O-O"),
      MapTile.generateRow("O-OO--O-O-O-O-O-O-O-O-O-O----O"),
      MapTile.generateRow("O----OO-O-O---O---O---O---OOOO"),
      MapTile.generateRow("OOOOOO--O-OOOOOOOOOOOOOOOOOOOO"),
      MapTile.generateRow("O------OO--------------------O"),
      MapTile.generateRow("O-OOOOOOOOOOOOOOOOOOOOOOOOOO-O"),
      MapTile.generateRow("O----------------------------O"),
      MapTile.generateRow("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")
    )
    var startingLocation = new GridLocation(1,10)
    var endingLocation =  new GridLocation(28,10)
    var listLoc: List[GridLocation] = PathFinding.findPath(startingLocation,endingLocation,map)
    var list = List((1,2),(3,4),(5,6),(7,8))
    println("Path Location")
    for(i<-listLoc){
      println(i.x,i.y)
    }

  }
}
