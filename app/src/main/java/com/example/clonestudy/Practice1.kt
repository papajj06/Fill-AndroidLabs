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


//Null 처리 - nullabale , NonNull
fun main(){
    nullCheck()
    ignoreNull("hello")
}

private fun nullCheck() {
    //NPE : Null Pointer Exception

    var name: String = "Subeen"
    // var nullName : String = null // String 타입은 null일 수 없음
    var nullName: String? = null // ?만 붙여주면 nullable 타입이 . ?를 넣어줘야하기 때문에 타입 생략 불가능
    var nameInUpperCase = name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase()
    //nullName이 null이면 null을 반환하고 null이 아니면 uppercase를 실행

    // ?: -> 엘비스 연산자
    val lastName: String? = "Kim"
    val fullName = name + " " + (lastName ?: "No lastName")
    // lastName이 null이면 옆에 문구 반환, null이 아니면 lastName 출력
    println(fullName)
}

// !!
private fun ignoreNull(str: String?) { // str은 null일 수도 있고 아닐 수도 있다.
    // val mNotNull : String = str // str이 null일 수도 있기 때문에 에러
    val mNoteNull: String = str!! // !!을 붙여주면 null이 아니라는 것을 보증
    val upper = mNoteNull.uppercase() // ?를 쓰지 않아도 됨
    println(upper)

    val email: String? = "papajj06@naver.com "
    // let : 자신의 receiver 객체를 람다식 내부로 옮겨서 실행하는 구문
    email?.let{ //email이 null이 아니면 let을 실행하므로 null인 경우는 실행 x -> 안전함
        println("My email is ${email}")
        println("My email is ${it}") // it으로도 가능
    }

}