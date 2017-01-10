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

  def isPermutationTrivial(str1: String, str2: String): Boolean = {
    if(str1.length != str2.length)
      return false

    var remainingStr = str2

    for( i <- 0 to str1.length-1) {
      remainingStr = RemoveChar(str1(i),remainingStr)
      if(remainingStr == null){
        return false
      }
    }

    return true
    }

  def RemoveChar(char : Char, str: String): String ={
    for( i <- 0 to str.length-1){
      if(str(i) == char){
        return str.substring(0,i) + str.substring(i+1)
      }
    }
    return null
  }

  def isPermutationLinkedHashTable(str1: String, str2: String): Boolean ={
    if(str1.length != str2.length){
      return false
    }

    val frequencyMap1 = new LinkedHashMap()
    val frequencyMap2 = new LinkedHashMap()

    for( i <- 0 to str1.length-1) {
      frequencyMap1.put(str1(i).toInt,str1(i).toString)
    }
    for( j <- 0 to str2.length-1) {
      frequencyMap2.put(str2(j).toInt,str2(j).toString)
    }

    for( k <- 0 to str1.length-1) {
      var test1 = frequencyMap1.getFrequency(str1(k).toInt)
      var test2 = frequencyMap2.getFrequency(str1(k).toInt)

      if(frequencyMap1.getFrequency(str1(k).toInt) != frequencyMap2.getFrequency(str1(k).toInt)){
        return false
      }
    }
    return true
  }
}
