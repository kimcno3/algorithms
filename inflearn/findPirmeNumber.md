# :pushpin: 소수 찾기

## 문제 설명
사용자가 입력한 숫자가 소수인지 아닌지 알려주는 프로그램

## 구현 코드
```jsx
// Javascript

var isPrime = true; // boolean 변수 선언, 소수판별
var n = Number(prompt("숫자를 입력해주세요")); // input

for(i = 2; i < n; i++){ // 1을 제외한 2부터 n까지 나머지값 계산
    if (n % i === 0){ // 나눠지는 수가 존재한다면
        isPrime = false; // 소수가 아니다.
        break; // 불필요한 루프를 방지!!
    }
}

if (isPrime){
    console.log(n +' 은(는) 소수가 맞습니다.');
}else {
    console.log(n +' 은(는) 소수가 아닙니다.');
}
```
## 추가 기능
- 1부터 1000사이의 수 중 소수들을 알려주는 프로그램
- 객체와 메소드를 활용하여 구현

## 구현 코드
```jsx
// 객체 선언
var numbers = {
    'all' : [],
    'prime' : []
};
// 1 ~ 1000 숫자 배열에 할당
numbers.addAll = function(max_num) {
    for(i=0 ; i < max_num ; i++) {
        var allNumbers = (this.all[i] = i+1);
    }
    return allNumbers;
}
// 소수 판별
numbers.isPrime = function(number) {
    var prime_num = [];

    for (i=2 ; i < this.all.length ; i++) {
        var n = this.all[i]; // 2부터 하나의 숫자를 할당
        var isPrime = true; // 소수판별을 위한 boolean 변수
        
        // 2부터 n까지의 수 중 소수존재여부 파악
        for (j = 2 ; j < n ; j++ ) {
            // 소수가 아니라면, 반복문 종료
            if (n % j === 0) { 
                isPrime = false;
                break;
            }
        }
        // 소수라면 배열에 추가 , 아니면 continue
        if (isPrime){
            prime_num.push(n);
        }else {
            continue;
        }
    }
    // 소수만 담긴 배열 return
    return prime_num;
}
// 소수값 배열 선언
numbers.addPrime = function(number){
    var prime_num = this.prime = number; 
    return prime_num;
}
// 소수값 출력
numbers.getAllPrimes = function(){ 
    for (i = 0 ; i < this.prime.length ; i++){
        var primes = this.prime[i];
        console.log(primes);
    }
}
// 메소드 모음 
numbers.Primes = function(num) {
    // 전체 숫자 추가
    this.addAll(num);

    // 소수 판별 , 함수의 return값을 각 변수에 할당
    var number = this.all.length;
    var primeNumber = this.isPrime(number);
    
    // 소수만 리스트에 추가
    this.addPrime(primeNumber);

    // 화면에 출력
    this.getAllPrimes();
}
// 메소드 실행
number.Primes(1000);
```
