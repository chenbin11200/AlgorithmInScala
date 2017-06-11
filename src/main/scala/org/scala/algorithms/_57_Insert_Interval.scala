package org.scala.algorithms

import scala.collection.mutable.ListBuffer

/**
  * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
  * ou may assume that the intervals were initially sorted according to their start times.
  * Example 1:
  * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
  * Example 2:
  * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
  * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]
  */

class Interval(s: Int, e: Int){
  var start = s
  var end = e
}

object _57_Insert_Interval extends App {
  def insert(intervals: List[Interval], newInterval: Interval) : List[Interval] = {
    var mergedStart = newInterval.start
    var mergedEnd = newInterval.end
    var resultFirst= new ListBuffer[Interval]()
    var resultEnd= new ListBuffer[Interval]()

    for (item <- intervals) {
      if (item.end < mergedStart) {
        resultFirst += item
      }
      else if (item.start > mergedEnd) {
        resultEnd += item
      }
      else {
        mergedStart = math.min(item.start, mergedStart)
        mergedEnd = math.max(item.end, mergedEnd)
      }
    }

    return ((resultFirst += new Interval(3,5)) ++ resultEnd.toList).toList
  }

//Test case
  insert( List(new Interval(1,2),new Interval(3,5),new Interval(6,7),new Interval(8,10),new Interval(12,16)),
          new Interval(4,9))
}

