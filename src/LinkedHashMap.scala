/**
  * Created by dccho on 1/9/2017.
  */
class LinkedHashMap() {

  val TABLE_SIZE = 128

  var table: Array[LinkedHashEntry] = new Array[LinkedHashEntry](TABLE_SIZE)
  for( i <- 0 to table.length-1){
    table(i) = null
  }

  def put(key:Int, value:String): Unit ={
    val hash: Int = key % TABLE_SIZE

    if(table(hash) == null){

      table(hash) = new LinkedHashEntry(key, value)

    }else{

      var currHashEntry = table(hash)

      while (currHashEntry.getNext() != null){
        currHashEntry = currHashEntry.getNext()
      }
        currHashEntry.setNext(new LinkedHashEntry(key,value))
    }
  }

  def getFrequency(key:Int): Int = {
    val hash: Int = key % TABLE_SIZE
    var count = 0

      var currHashEntry = table(hash)
      while(currHashEntry != null){
        currHashEntry = currHashEntry.getNext()
        count = count + 1
      }

    return count
  }


}
