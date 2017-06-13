package org.scala.algorithms

/**
  * Created by Bin on 17/6/12.
  */
object _59_Spiral_Matrix_II extends App{
  def generateMatrix(n: Int): List[List[Int]] = {
    var maxValue = n * n
    var result: List[List[Int]] = List()

    while (maxValue >= 1){
      result = result.reverse.transpose //Rotate matrix 90 degrees clockwise

      var newListLength = 1 //If no element in result, newList will have 1 element
      if(!result.isEmpty){
        newListLength = result.head.length
      }

      val newList = List.range(maxValue - newListLength + 1, maxValue + 1) // A concise way initialize List
      result = (newList :: result)
      maxValue = maxValue - newListLength
    }

    return result
  }

  print(generateMatrix(4))
}
