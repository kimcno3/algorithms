function solution(s) {
    var answer = '';
    if (s.length%2!==0) answer = s[Math.floor(s.length/2)];
    else answer = s.substr((s.length/2)-1, 2)
    return answer;
}