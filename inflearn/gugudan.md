# :pushpin: 구구단

## 문제 설명
- `2 X 1` 부터 `9 X 9` 까지의 구구단 결과를 출력
## 구현 코드
```jsx
// Javascript

var results = []; // 전체 결과값
var length = 9; // 최대 단 수(9단)
// 2단 ~ 9단까지의 구구단 결과 계산 후 차례대로 push
for(var i=2; i <= length; i++) {
    for(var j=1; j <=length; j++) {
        var n = i*j;
        results.push(n);
    }
}
// 단수 별로 구분 후 출력
for(var i=1; i < length; i++) {
    console.log((i+1) + '단');
    for(var j=0; j < length; j++) {
        var n = (9 * (i - 1)) + j; // 원소 9개씩 구분
        console.log((i+1)+' X '+ (j+1) + ' = ' + results[n]);
    }
}

// 객체 활용 구구단 구현
gugudan = {
    'num' : 0,
    'results' : []
};

gugudan.calculrate = function(num) {
    let results = [];

    for(let i=2; i <= num; i++) {
        for(let j=1; j <= 9; j++) {
            let n = i*j;
            results.push(n);
        }
    }
    return results;
}
gugudan.print = function(results,num) {
    for(let i=1; i < num; i++) {
        console.log((i+1) + '단');
        for(let j=0; j < 9; j++) {
            let n = (9 * (i - 1)) + j; // 원소 9개씩 구분
            console.log((i+1)+' X '+ (j+1) + ' = ' + results[n]);
        }
    }
}
gugudan.main = function() {
    // 9단까지 출력을 위한 변수 선언
    let num = this.num = 9; 
    // 계산된 결과를 변수에 선언
    let results = this.results = this.calculrate(num); 
    // 계산 결과 출력
    this.print(results, num);
}
// main 함수 실행
gugudan.main();
```

<br>

# :pushpin: 추가 기능

## 문제 설명
- 사용자가 입력한 값에 따라 크기가 다른 구구단을 계산해 출력한다.
- 예를 들어 사용자가 "8,7"과 같은 문자열을 입력하면 팔칠단을 구현한다. 
- 팔칠단은 2 * 1 ... 2 * 7, 3 * 1 ... 3 * 7, ... , 8 * 1 ... 8 * 7 까지 구현하는 것을 의미한다.
- 객체를 활용 구현한다.
## 구현 코드
```jsx
// 구구단 객체 생성
gugudan = {
    'input' : '',
    'numbers' : [],
    'results' : []
};

// ','를 기준 두 수를 나누고 배열에 원소로 저장
gugudan.split_num = function(input) {
    let splitNumber = input.split(',');
    let numbers = [];

    for (let i=0; i<=1; i++){
        numbers.push(Number(splitNumber[i]));
    }
    
    return numbers;
};
// 입력받은 숫자를 기준으로 구구단을 계산하고 결과값을 저장
gugudan.calculation = function(numbers) {
    let results = [];

    for (let i=1; i <= numbers[0]; i++) {
        for (let j=1; j <= numbers[1]; j++) {
            results.push(i*j);
        }
    }
    return results;
};
// 받은 결과값을 차례대로 출력
gugudan.print = function(numbers , results) {
    let result = [];

    for (var i=1; i<=numbers[0]; i++) {
        console.log('구구단 ' + i + '단 X ' + numbers[1] +'까지')
        for (var j=1; j<=numbers[1]; j++) {
            result = results.shift();
            console.log(i + ' X ' + j + ' = ' + result);
        }
    }
};
// main 함수
gugudan.main = function() {
    // 입력값 할당
    let input = prompt('숫자 두개를 입력하세요');
    // 두개의 숫자 할당
    let numbers = this.numbers = this.split_num(input);
    // 결과값 할당
    let results = this.results = this.calculation(numbers);
    // 출력
    this.print(numbers , results);
};
// 구구단 계산기 실행
gugudan.main();
```
