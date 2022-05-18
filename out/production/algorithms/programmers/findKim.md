# :pushpin: 서울에서 김서방 찾기

## 문제 설명
String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.

seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

## 제한 사항
- seoul은 길이 1 이상, 1000 이하인 배열입니다.
- seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
- "Kim"은 반드시 seoul 안에 포함되어 있습니다.

## 입출력 예
|seoul|return|
|--|--|
|["Jane", "Kim"]|"김서방은 1에 있다"|

## 작성 코드
```jsx
function solution(seoul) {
    for (let i=0; i<seoul.length; i++) {
        if (seoul[i] === 'Kim') {
            var x = i;
        }
    }
    var answer = '김서방은 '+x+'에 있다';
    return answer;
}
```
## 코드 설명
1. `seoul` 배열의 요소 하나씩 loop
2. 요소 중 `Kim`이 있는 경우, 변수 `x`의 값에 해당 요소의 인덱스값인 `i`값을 할당
3. 문자열과 `x`를 더하여 `answer` 변수에 할당 및 return
