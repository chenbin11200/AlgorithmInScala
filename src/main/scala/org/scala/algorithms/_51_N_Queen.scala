package org.scala.algorithms

/**
  * Created by Bin on 17/5/30.
  */
object _51_N_Queen extends App {
  var count = 0

  def NQueen(n: Int) = {
    println("Start Calculation")
    val solution = new Array[Int](n)

    PutQueenAt(0, solution)
    println("End Calculation")
  }

  def printSolution(solution: Array[Int]) = {
    count+=1
    println("Find a solution "+count)
    println(solution.mkString("(",",",")"))
  }

  def PutQueenAt(rowIndex: Int, solution: Array[Int]): Boolean = {
    for (columnIndex <- 0 until 8){
      if( CanPutQueenAt(rowIndex, columnIndex, solution)){
        solution(rowIndex) = columnIndex
        if(rowIndex >= 7){
          printSolution(solution)
        }
        else {
          PutQueenAt(rowIndex + 1, solution)
        }
      }
      else()
    }
    return false
  }

  def CanPutQueenAt(rowIndex: Int, columnIndex: Int, solution: Array[Int]): Boolean = {
    for (i <- 0 until rowIndex){
      if ( solution(i) == columnIndex
        || Math.abs(i - rowIndex) == Math.abs(solution(i) - columnIndex)
      //The following is not the same
      //||solution(i) + i == rowIndex + columnIndex
      //||Math.abs(solution(i)-i) == Math.abs(rowIndex - columnIndex)
      ){
        return false
      }
    }
    return true
  }

  NQueen(8)
}