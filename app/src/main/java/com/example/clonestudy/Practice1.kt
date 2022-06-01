package com.example.clonestudy

fun max1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//위의 max1 함수를 간략하게 한줄로 표현할 수 있다. -> max2
fun max2(a: Int, b: Int) = if (a > b) a else b


// when 사용
fun check(score: Int){
    when(score){
        in 90..100 -> println("good")
        in 10..80 -> println("soso")
        else -> println("okay")
    }
}

// kotlin의 모든 함수는 expression 이다. -> 아무리 반환값이 적혀 있지 않더라도 디폴트, Unit 이라는 반환함.


//Array and List
// Array는 처음에 크기를 딱 정해줘야 하낟.
//List는 1) List 2) MutableList가 있음. , list는 array와 다르게 인터페이스임. 그래서 각 자리값은 get(int)로 가져와야함.

//arrayListOf을 통해 리스트 생성 가능

fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1,"d",3)
    val list2 = listOf(1,'d',11)
    array[0]=3
    val result = list.get(0)

    // arrayList라고 하면 값을 추가, 삭제 등 할 수 있으니까 즉 변동이 존재하므로 var을 써야할 것 같지만
    // val을 써도 되고 쓴다. 그 이유는 어차피 arraylista의 참조값은 변하지 않으므로 상관 없다.
    // var arrayList = arrayListOf<Int>()
    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0]=20


}