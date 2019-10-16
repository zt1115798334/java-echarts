{
"backgroundColor": "#f2f2f2",
"title": {
"text": "",
"subtext": "",
"x": "center",
"y": "5%"
},
"tooltip": {
"trigger": "item",
"formatter": "{b}"
},
"roam": "true",
"dataRange": {
"min": 0,
"max": 5,
"x": "5%",
"y": "80%",
"splitList": [
{
"start": 3.5,
"end": 5,
"label": "发展区",
"color": "#ff704d"
},
{
"start": 2.5,
"end": 3.5,
"label": "未发展区",
"color": "#4FA8F9"
}
],
"color": [
"red",
"blue"
]
},
"toolbox": {
"show": true,
"orient": "vertical",
"x": "right",
"y": "center",
"feature": {
"mark": {
"show": true
},
"dataView": {
"show": true,
"readOnly": false
},
"dataZoom": {
"show": true
},
"restore": {
"show": true
},
"saveAsImage": {
"show": true
}
}
},
"roamController": {
"show": true,
"x": "right",
"mapTypeControl": {
"china": true
}
},
"series": [
{
"name": "投标",
"type": "map",
"mapType": "china",
"roam": false,
"itemStyle": {
"normal": {
"label": {
"show": true
}
},
"emphasis": {
"label": {
"show": true
}
}
},
"data": [
{
"name": "山东",
"value": 3
},
{
"name": "河南",
"value": 4
},
{
"name": "重庆",
"value": 4
},
{
"name": "广西",
"value": 4
},
{
"name": "四川",
"value": 4
},
{
"name": "海南",
"value": 4
},
{
"name": "北京",
"value": 4
},
{
"name": "天津",
"value": 4
},
{
"name": "上海",
"value": 4
},
{
"name": "江苏",
"value": 3
},
{
"name": "浙江",
"value": 3
},
{
"name": "福建",
"value": 3
},
{
"name": "安徽",
"value": 4
},
{
"name": "江西",
"value": 3
},
{
"name": "湖北",
"value": 4
},
{
"name": "湖南",
"value": 4
},
{
"name": "广东",
"value": 4
},
{
"name": "辽宁",
"value": 4
},
{
"name": "吉林",
"value": 3
},
{
"name": "黑龙江",
"value": 3
},
{
"name": "内蒙古",
"value": 3
},
{
"name": "云南",
"value": 4
},
{
"name": "贵州",
"value": 4
},
{
"name": "山西",
"value": 4
},
{
"name": "陕西",
"value": 4
},
{
"name": "甘肃",
"value": 4
},
{
"name": "新疆",
"value": 4
},
{
"name": "西藏",
"value": 3
},
{
"name": "青海",
"value": 4
},
{
"name": "宁夏",
"value": 4
},
{
"name": "台湾",
"value": 4
},
{
"name": "香港",
"value": 3
},
{
"name": "澳门",
"value": 3
},
{
"name": "南海诸岛",
"value": 0,
"itemStyle": {
"normal": {
"opacity": 0,
"label": {
"show": false
}
}
}
}
]
}
]
}