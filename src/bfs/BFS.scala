package bfs

import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.EndOfDataDecoderException

object BFS {

  def bfs[A](graph: Graph[A], startID: Int, endID:Int): List[Int]= {

    var explored: Set[Int] = Set(startID)
    var map:Map[Int,Int]=Map()

    val toExplore: Queue[Int] = new Queue()
    toExplore.enqueue(startID)

    while (!toExplore.empty()) {
      val nodeToExplore = toExplore.dequeue()
      for (node <- graph.adjacencyList(nodeToExplore)) {
        if (!explored.contains(node)) {
          map += node -> nodeToExplore
          toExplore.enqueue(node)
          explored = explored + node
          if (node == endID) {

          }
        }
      }
    }
    recusive(endID,map)
  }

  def recusive (endID:Int, map:Map[Int,Int]):List[Int]= {
    if(map.keys.toList.contains(endID)){
      recusive(map(endID), map) ::: List(endID)
    }else{
      List(endID)
    }
  }

}
