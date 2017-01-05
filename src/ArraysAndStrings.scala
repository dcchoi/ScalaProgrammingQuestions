/**
  * Created by dccho on 1/4/2017.
  */
object ArraysAndStrings {

  def hasAllUniqueCharsTrivial(str:String): Boolean ={
    if(str == null){
      return  true
    }
    for( i <- 0 to str.length() - 1){
      for( j <- 0 to str.length() - 1){
        if(i != j && str(i) == str(j)){
          return  false
        }
      }
    }
     return true
  }

  def hasAllUniqueCharsHashTable(str:String): Boolean = {
    val hashMap = new HashMap()

    for ( i <- 0 to str.length - 1){
      var test  = hashMap.get(str(i).hashCode())
      if(hashMap.get(str(i).hashCode()) == null)
        hashMap.put(str(i).hashCode(),str(i).toString)
      else
        return  false
    }
    return  true
  }

  def hasAllUniqueCharsASCII(str:String): Boolean = {
    //128 is ASCII size
    var table = new Array[Boolean](128)
    for( i <- 0 to table.length-1){
      table(i) = false
    }

    for ( i <- 0 to str.length - 1) {
      if(table(str(i).toInt) == false){
        table(str(i).toInt) = true
      }else{
        return false
      }
    }
    return  true
  }

}
