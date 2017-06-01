package org.scala.algorithms

/**
  * Created by Bin on 6/1/2017.
  */
object _53_Maximum_Subarray extends App {
  def maxSubArray(nums: List[Int]): Int = {
    var currentMaxSum = nums.head
    var maxSum = nums.head

    for(item <- nums.tail){
      currentMaxSum = math.max(item + currentMaxSum, item)
      maxSum = math.max(currentMaxSum, maxSum)
    }

    return maxSum
  }

  //Test
  println(maxSubArray(List(-2,1,-3,4,-1,2,1,-5,4)))
}
