package solver

import maze.{GridLocation, MapTile, PhysicsVector}
import bfs._


object PathFinding {

  def findPath(start: GridLocation, end: GridLocation, map: List[List[MapTile]]): List[GridLocation] = {

    val goods:Map[GridLocation,Boolean]=
      (for(i<-map)yield{
        for(w<-i) yield {
          new GridLocation(i.indexOf(w), map.indexOf(i)) -> w.passable
      }
    }).flatten.toMap


    var count:Int = 0
    var graph:Graph[GridLocation] = new Graph()
    for(i<-goods.keys) {
      graph.addNode(count,i)
      count+=1
    }

    for(i<-graph.nodes.keys) {
      for (z <- graph.nodes.keys) {
        if (z != i) {
          if (goods(graph.nodes(i)) == goods(graph.nodes(z))) {
            var x1 = graph.nodes(i).x
            var y1 = graph.nodes(i).y
            var x2 = graph.nodes(z).x
            var y2 = graph.nodes(z).y
            if ((x1 == x2 && Math.abs(y1 - y2) == 1) || (y1 == y2 && Math.abs(x1 - x2) == 1)) {
              if(goods(graph.nodes(i)) && goods(graph.nodes(z)))
                graph.addEdge(i, z)
            }
          }
        }
      }
    }
    var start2 = 0
    var end2 = 0
    for(i<-graph.nodes.keys){
      if(graph.nodes(i)==start){
        start2 = i
      }else if(graph.nodes(i)==end){
        end2 = i
      }
    }

    var list:List[Int]= bfs.BFS.bfs(graph,start2,end2)

    var list2:List[GridLocation]=List()

    for(i<-list){
      list2:+=graph.nodes(i)
    }
    list2
  }



  def getVelocity(path: List[GridLocation], currentLocation: PhysicsVector): PhysicsVector = {
    var path2 = path.slice(0,path.length-1)
    var physicsV =new PhysicsVector(0,0)
    var grid = new GridLocation(Math.floor(currentLocation.x).toInt,Math.floor(currentLocation.y).toInt)
    for(i<-path2){
      if(path.last == grid){
        var inputX = path.last.x+0.5
        var inputY = path.last.y+0.5
        var range=currentLocation.distance2d(new PhysicsVector(inputX,inputY))
          if(range>0.1){
            val inputX=(path(path.indexOf(i)+1).x+0.5)-currentLocation.x
            val inputY=(path(path.indexOf(i)+1).y+0.5)-currentLocation.y
            var physicsNormal = new PhysicsVector(inputX,inputY).normal2d()
            physicsV=new PhysicsVector(physicsNormal.x*5,physicsNormal.y*5)
          }
        }
      if(i==grid){
          val inputX=(path(path.indexOf(i)+1).x+0.5)-currentLocation.x
          val inputY=(path(path.indexOf(i)+1).y+0.5)-currentLocation.y
          var physicsNormal = new PhysicsVector(inputX,inputY).normal2d()
          physicsV=new PhysicsVector(physicsNormal.x*5,physicsNormal.y*5)
      }
    }
    physicsV
  }









}
