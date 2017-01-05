/**
  * Created by dccho on 1/4/2017.
  */
class HashMap {

  val TABLE_SIZE: Int = 128

  var table: Array[HashEntry] = new Array[HashEntry](TABLE_SIZE)
  for( i <- 0 to table.length-1){
    table(i) = null
  }

  def put(key:Int, value:String): Unit ={
    var hash: Int = key % TABLE_SIZE

    while (table(hash) != null && table(hash).getKey() != key)
      hash = (hash + 1) % TABLE_SIZE

    table(hash) = new HashEntry(key,value)
  }

  def get(key:Int): HashEntry ={
    var hash: Int = key % TABLE_SIZE

    while(table(hash) != null && table(hash).getKey() != key)
      hash = (hash + 1) % TABLE_SIZE

    if(table(hash) == null)
      return  null
    else
      return table(hash)
  }
}
