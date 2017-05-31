package org.scala.algorithms

/**
  * Created by Bin 5/31/2017.
  * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
  * You may assume that each input would have exactly one solution, and you may not use the same element twice.
  *
  * Given nums = [2, 7, 11, 15], target = 9,
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1].
  */

object _1_Two_Sum extends App{

  TwoSum(List(3,7,1,6,5,67,89,12), 9)

  def TwoSum(nums: List[Int], target: Int): Unit = {
    var numMap: Map[Int, Int] = Map()
      for (i <- 0 until nums.length) {
        numMap.get(nums(i)).foreach(item => {
          println(List(item, i))
          return
        })
//        You can also use the following, easier to understand, but Some().get you should use it carefully
//        if(numMap.keys.exists(_ == nums(i))){
//          println(List(numMap.get(nums(i)).get, i) )
//          return
//        }
        numMap += (target - nums(i) -> i)
      }
  }
}
