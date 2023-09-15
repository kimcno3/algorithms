function solution(seoul) {
    for (let i=0; i<seoul.length; i++) {
        if (seoul[i] === 'Kim') {
            var x = i;
        }
    }
    
    var answer = '김서방은 '+x+'에 있다';
    return answer;
}