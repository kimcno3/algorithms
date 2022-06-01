# :pushpin: 가운데 글자 가져오기

## 문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

## 제한 사항
- s는 길이가 1 이상, 100이하인 스트링입니다.

## 입출력 예
|s|return|
|--|--|
|"abcde"|"c"|
|"qwer"|"we"|

## 작성 코드
```jsx
function solution(s) {
    var answer = '';
    // 배열 길이가 홀수
    if (s.length%2 !== 0) {
        answer = s[Math.floor(s.length/2)];
    }
    // 배열 길이가 짝수
    else {
        answer = s.substr((s.length/2)-1, 2);
    }
    return answer;
}
```
## 코드 설명
배열길이가 홀수인지 짝수인지에 따라 반환할 문자의 수가 다르기 때문에 나눠서 생각해봐야 한다.

**배열길이가 홀수일 경우**

|배열길이|`answer`의 인덱스값|배열길이/2|
|:--:|:--:|:--:|
|5 (`"abcde"`)|2 (`"c"`)|2.5|
- 배열의 전체 길이를 반으로 나누고 내림했을 때 나오는 값의 인덱스 위치에 있는 문자열
- `Math.floor()` : 주어진 숫자와 같거나 작은 정수 중에서 가장 큰 수를 반환([추가설명](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Math/floor))

<br>

**배열길이가 짝수인 경우**

|배열길이|`answer`의 인덱스값|배열길이/2|
|:--:|:--:|:--:|
|4 (`"qwer"`)|1, 2 (`"we"`)|2|

- 배열의 전체 길이를 반으로 나누고 -1한 값의 인덱스 위치에서부터 2개의 문자열
- `substr()` : 원하는 문자열만 골라낼 수 있는 함수([추가설명](https://github.com/kimcno3/TIL/blob/main/programming_language/javascript.md#substring--substr))

