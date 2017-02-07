/**
  * Created by dccho on 1/4/2017.
  */
object ArraysAndStrings {

  def hasAllUniqueCharsTrivial(str: String): Boolean = {
    if (str == null) {
      return true
    }
    for (i <- 0 to str.length() - 1) {
      for (j <- 0 to str.length() - 1) {
        if (i != j && str(i) == str(j)) {
          return false
        }
      }
    }
    return true
  }

  def hasAllUniqueCharsHashTable(str: String): Boolean = {
    val hashMap = new HashMap()

    for (i <- 0 to str.length - 1) {
      var test = hashMap.get(str(i).hashCode())
      if (hashMap.get(str(i).hashCode()) == null)
        hashMap.put(str(i).hashCode(), str(i).toString)
      else
        return false
    }
    return true
  }

  def hasAllUniqueCharsASCII(str: String): Boolean = {
    //128 is ASCII size
    var table = new Array[Boolean](128)
    for (i <- 0 to table.length - 1) {
      table(i) = false
    }

    for (i <- 0 to str.length - 1) {
      if (table(str(i).toInt) == false) {
        table(str(i).toInt) = true
      } else {
        return false
      }
    }
    return true
  }

  def isPermutationTrivial(str1: String, str2: String): Boolean = {
    if (str1.length != str2.length)
      return false

    var remainingStr = str2

    for (i <- 0 to str1.length - 1) {
      remainingStr = RemoveChar(str1(i), remainingStr)
      if (remainingStr == null) {
        return false
      }
    }

    return true
  }

  def RemoveChar(char: Char, str: String): String = {
    for (i <- 0 to str.length - 1) {
      if (str(i) == char) {
        return str.substring(0, i) + str.substring(i + 1)
      }
    }
    return null
  }

  def isPermutationLinkedHashTable(str1: String, str2: String): Boolean = {
    if (str1.length != str2.length) {
      return false
    }

    val frequencyMap1 = new LinkedHashMap()
    val frequencyMap2 = new LinkedHashMap()

    for (i <- 0 to str1.length - 1) {
      frequencyMap1.put(str1(i).toInt, str1(i).toString)
    }
    for (j <- 0 to str2.length - 1) {
      frequencyMap2.put(str2(j).toInt, str2(j).toString)
    }

    for (k <- 0 to str1.length - 1) {
      var test1 = frequencyMap1.getFrequency(str1(k).toInt)
      var test2 = frequencyMap2.getFrequency(str1(k).toInt)

      if (frequencyMap1.getFrequency(str1(k).toInt) != frequencyMap2.getFrequency(str1(k).toInt)) {
        return false
      }
    }
    return true
  }

  def URLifyTrivial(charArray: Array[Char]): Array[Char] = {
    var newCharSize = 0
    for (i <- 0 to charArray.length - 1) {
      if (charArray(i) == ' ') {
        newCharSize = newCharSize + 3
      } else {
        newCharSize = newCharSize + 1
      }
    }
    val newCharArray = new Array[Char](newCharSize)

    var i = 0
    var j = 0
    while (j < charArray.length) {
      if (charArray(j) == ' ') {
        newCharArray(i) = '%'
        newCharArray(i + 1) = '2'
        newCharArray(i + 2) = '0'
        i = i + 3
      } else {
        newCharArray(i) = charArray(j)
        i = i + 1
      }
      j = j + 1
    }

    return newCharArray
  }

  def palindromePermutation(str: String): Boolean = {
    val frequencyMap = new LinkedHashMap()
    val trimmedStr = str.filterNot((x: Char) => x.isWhitespace).toUpperCase

    for (i <- 0 to trimmedStr.length - 1) {
      frequencyMap.put(trimmedStr(i).toInt, trimmedStr(i).toString)
    }

    var hasSingleFlag = false;
    for (i <- 0 to frequencyMap.TABLE_SIZE) {
      if (frequencyMap.getFrequency(i) % 2 != 0) {
        var test = frequencyMap.getFrequency(i)
        if (hasSingleFlag == false) hasSingleFlag = true else return false
      }
    }
    return true
  }

  def isOneAway(uneditedStr: String, editedStr: String): Boolean = {

    val zeroAwayReplace = (uneditedStr: String, editedStr: String, index: Int) => {
      val charArrayStr = uneditedStr.toCharArray()
      charArrayStr(index) = editedStr(index)
      if (charArrayStr.mkString("") != editedStr) {
        return false
      } else {
        return true
      }
    }: Boolean

    val oneAwayRemove = (str1: String, str2: String, index: Int) => {
      val charArrayStr = str1.toCharArray()
      charArrayStr(index) = ' '

      if (charArrayStr.mkString("").trim != str2) {
        return false
      } else {
        return true
      }
    }: Boolean




    if (uneditedStr == editedStr) {
      return true
    }
    if (uneditedStr.length > editedStr.length + 1 || uneditedStr.length < editedStr.length - 1) {
      return false
    }

    var i = 0
    var result = true
    while ((i < uneditedStr.length - 1 && i < editedStr.length -1) || !result) {
      if(editedStr(i) == null){
        //could be insert
        result = oneAwayRemove(editedStr, uneditedStr, i)
      }
      else if(uneditedStr(i) == null){
        //could be remove
        result = oneAwayRemove(uneditedStr, editedStr, i)
      }
      else if (uneditedStr(i) != editedStr(i)) {
        if (uneditedStr.length == editedStr.length) {
          //could be changed character
          result = zeroAwayReplace(uneditedStr, editedStr, i)
        }
        else if (uneditedStr.length > editedStr.length) {
          //could be removal
          result = oneAwayRemove(uneditedStr, editedStr, i)
        } else {
          //could be insert
          result = oneAwayRemove(editedStr, uneditedStr, i)
        }
      }
      i = i + 1

    }
    result
  }
}
