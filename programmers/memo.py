def solution(price, money, counts):
    count = 1
    total = 0
    while count <= counts :
        total += price * count
        count += 1
    if total > money :
        result = total - money
    else: result = 0

    answer = result
    return answer

answer = solution(3,20,4)
print(answer)