from wordcloud import WordCloud
import json
# 예전에 만들어 놓은 webtoons.json 파일을 가져온다.
# 고양체 파일도 가져온다.

cloud = WordCloud(font_path='Goyang.otf',
                  background_color='white',
                  max_words=30,
                  width=400,
                  height=300)

with open('webtoons.json', encoding='UTF8') as file:
    webtoons = json.load(file)

res = dict()
for webtoon in webtoons['webtoons']:
    # webtoon : {"title": "전지적 독자 시점", "star" : "9.96"}
    res[webtoon['title']] = int(float(webtoon['star']) * 100) # 100을 곱하는 이유는 wordcloud가 크기를 잡아줄 것이기 때문이다.
    # res : {"전지적 독자 시점" : 996}

visual = cloud.fit_words(res)
visual.to_image()
visual.to_file('cloud01.png')