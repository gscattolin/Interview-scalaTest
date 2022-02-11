import scala.collection.mutable.ListBuffer

import scala.io.StdIn.readLine

object Test1 extends App {

  def spinWords(sentence: String): String = {
    val strb= new StringBuilder
    for ( x <- sentence.split("\\s+")){
      val vv=if (x.length>=5) x.reverse else x
      strb.append(vv)
      strb.append(" ")
    }
    strb.toString().strip()
  }

  def narcissistic(n: Int): Boolean = {
    n.toString.map(x=>math.pow(x.asDigit,n.toString.length)).sum==n
  }

  def chooseBestSum(t: Int, k: Int, ls: List[Int]): Int = {
    val candidates=ls.combinations(k)
    candidates.zipWithIndex.iterator.map(x=>(x._2,x._1.sum))
    0
  }

  def ListReplication2(num:Int,arr:List[Int]):List[Int] ={
    var lst=List[Int]()
    for (item <- arr){
      lst = lst ::: List.fill(num)(item)
    }
    lst
  }


  def ListReplication(num:Int,arr:List[Int]):List[Int] ={
    val lst=new ListBuffer[Int]()
    arr.foreach(x=>lst ++= ListBuffer.fill(num)(x))
    lst.toList
  }

  def fpFiltArarray(delim:Int,arr:List[Int]):List[Int] ={
    arr.filter(x => x<delim)
  }

  def fpFilterPositionsInList(arr:List[Int]):List[Int]={
    arr.zipWithIndex.collect({case (x,ind)  if ind % 2 ==0 =>x })
  }

  def fpFilterPositionsInListDiff(arr:List[Int]):List[Int]={
    for {
      (x,i) <- arr.zipWithIndex
      if i % 2 == 1
    } yield x
  }

  def exp(v:Double):Double={
    def factorial(n: Int) = (1 to n).product
    (0 until 10).map(x=> math.pow(v,x)/factorial(x)).sum
  }

  def AreaPolygon2(coords:List[(Int,Int)]):Double={
    val twoV=coords.take(2)
    val side= math.sqrt(math.pow(twoV.head._1-twoV.last._1,2)+math.pow(twoV.head._2-twoV.last._2,2))
    val apoth=side /(2* math.tan(math.Pi/coords.length))
    (coords.length * side * apoth)/2
  }

  def AreaPolygon(coords:List[(Int,Int)]):Double={
    (coords.last +: coords).sliding(2).map(x =>{
      val v1=x.head
      val v2 =x.last
      (v1._1*v2._2 - v1._2*v2._1)
    }
    ).sum.abs/2
  }

  def seqGen(c:Int,m:Int,l:Int):List[Int]={
//    def recGen(lst:ListBuffer[Int],maxLvl:Int):List[Int]={
//      lst match {
//        case lst if lst.length>maxLvl => lst.toList
//        case _ => {val newEl=lst.   recGen()}
//      }
//      lst.toList
//    }
    List(1,2)
  }

  def toRemember1(): Unit ={
    import scala.collection.mutable
    val map = mutable.Map.empty[Int,Int]
    val yourKey: Int = ???
    map.updateWith(yourKey){
      case Some(i) => Some(i+1)
      case None => Some(1)
    }
  }


  def plusMinus(arr: Array[Int]):List[Double]= {
    // Write your code here
     arr.groupBy { case x if x > 0 => 1  case x if x < 0 => -1 case 0 => 0}.
       map(x=>(x._1,x._2.length.toDouble/arr.length)).values.toList
  }

  def miniMaxSum(arr: Array[BigInt]):(BigInt,BigInt)= {
    // Write your code here
    val res=arr.combinations(4).map(x=>x.sum).toList.sorted
    (res.head,res.last)
  }


  //  println(spinWords("Hey wollef sroirraw"))
//  println(narcissistic(153))
//  var ts = List(50, 55, 56, 57, 58)
//  println(chooseBestSum(163, 3, ts)==163)
//  println(fpFiltArarray(3,List(10,9,8,2,7,5,1,3,0)))
//  println(fpFilterPositionsInList(List(2,5,3,4,6,7,9,8)))
//  println(exp(20))
//  println(AreaPolygon(List((1043,770),(551,990),(681,463))))
}

