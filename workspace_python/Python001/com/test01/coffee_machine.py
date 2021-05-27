def start():
    q = int(input('커피 몇 잔이 필요하신가요?'))
    p = int(input('돈을 넣어주세요 (1잔에 100원'))
    coffee(q, p)
    
def coffee(quantity, price):
    change = price * (quantity * 100)
    if change < 0:
        