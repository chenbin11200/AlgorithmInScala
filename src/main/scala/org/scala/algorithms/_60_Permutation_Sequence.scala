package org.scala.algorithms

import scala.collection.mutable.ListBuffer

/**
  * Created by Bin on 17/6/15.
  */
object _60_Permutation_Sequence extends App {
  def getPermutation(n:Int, k: Int): String = {
    val inputListBuffer = ListBuffer.range(1, n+1).map(_.toString)
    val resultBuffer: ListBuffer[String] = ListBuffer()
    var lengthCounter = inputListBuffer.length
    var countInGroup = k

    if(k > Range(1, lengthCounter + 1).product || k < 1){
      return "invalid k"
    }

    while(lengthCounter > 0){
      val groupCount = Range(1, lengthCounter).product
      val groupIndex = (countInGroup - 1)/groupCount

      if(inputListBuffer.length > groupIndex) {
        resultBuffer += inputListBuffer(groupIndex)
        countInGroup = countInGroup % groupCount
        if(countInGroup == 0){
          countInGroup = groupCount
        }
        inputListBuffer.remove(groupIndex)
      }
      lengthCounter -= 1
    }

    return resultBuffer.mkString

  }

  print(getPermutation(4,9))
}
