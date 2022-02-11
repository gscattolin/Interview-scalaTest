import org.scalatest.flatspec.AnyFlatSpec

class Test1Test extends AnyFlatSpec  {


  "plusminus" should "work" in{
    val arr = List(-4, 3, -9, 0, 4, 1).toArray
    val res=Test1.plusMinus(arr)
    assert(res.length==3)
  }

  "minMaxSum" should "work" in{
    val arr:Array[BigInt] = Array(793810624, 895642170, 685903712, 623789054, 468592370)
    val res=Test1.miniMaxSum(arr)
    assert(res._1!=1)
    assert(res._2!=1)
  }

}
